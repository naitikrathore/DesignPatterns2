package PractiseLLD.airlineManagementSystem.service;

import PractiseLLD.airlineManagementSystem.enums.BookingStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatStatus;
import PractiseLLD.airlineManagementSystem.model.*;
import PractiseLLD.airlineManagementSystem.strategy.PricingStrategy;
import PractiseLLD.airlineManagementSystem.strategy.StandardPricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class BookingService {
    private final Map<Long, Booking> bookings = new ConcurrentHashMap<>();
    private final AtomicLong bookingIdSequence = new AtomicLong(1);
    private final PricingStrategy pricingStrategy;

    public BookingService() {
        this(new StandardPricingStrategy());
    }

    public BookingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public Booking bookFlight(Passenger passenger, Flight flight, List<Seat> seats) {
        if (passenger == null || flight == null) {
            throw new IllegalArgumentException("Passenger and flight are required");
        }
        if (seats == null || seats.isEmpty()) {
            throw new IllegalArgumentException("At least one seat must be selected");
        }

        List<Seat> requestedSeats = new ArrayList<>(seats);

        for (Seat seat : requestedSeats) {
            if (!flight.getAircraft().getSeats().contains(seat)) {
                throw new IllegalArgumentException("Seat " + seat.getSeatNumber() + " does not belong to the flight");
            }
            if (seat.getStatus() != SeatStatus.Available) {
                throw new IllegalStateException("Seat " + seat.getSeatNumber() + " is not available");
            }
        }

        double totalAmount = requestedSeats.stream()
                .mapToDouble(seat -> pricingStrategy.calculatePrice(flight, seat))
                .sum();

        requestedSeats.forEach(seat -> seat.setStatus(SeatStatus.Booked));

        Booking booking = new Booking(passenger, flight, requestedSeats, totalAmount);
        long bookingId = bookingIdSequence.getAndIncrement();
        booking.setId(bookingId);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        bookings.put(bookingId, booking);
        return booking;

    }

    public Booking getById(String bookingId) {
        if (bookingId == null || bookingId.isBlank()) {
            return null;
        }
        try {
            long id = Long.parseLong(bookingId.trim());
            return bookings.get(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public BoardingPass checkIn(String bookingId) {
        Booking booking = getById(bookingId);
        if (booking == null) {
            throw new IllegalArgumentException("Booking not found for id: " + bookingId);
        }
        if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new IllegalStateException("Cancelled booking cannot be checked in");
        }

        booking.setBookingStatus(BookingStatus.CHECKED_IN);

        String firstSeat = booking.getSeats().stream()
                .findFirst()
                .map(Seat::getSeatNumber)
                .orElse("NA");

        LocalDateTime boardingTime = booking.getFlight().getDepartureTime() == null
                ? LocalDateTime.now().plusMinutes(30)
                : booking.getFlight().getDepartureTime().minusMinutes(45);

        String gate = "G" + ((booking.getFlight().getId() % 20) + 1);

        return new BoardingPass(
                "BP-" + booking.getId(),
                String.valueOf(booking.getId()),
                booking.getPassenger().getName(),
                booking.getFlight().getFlightNumber(),
                firstSeat,
                gate,
                boardingTime,
                UUID.randomUUID().toString()
        );
    }
}
