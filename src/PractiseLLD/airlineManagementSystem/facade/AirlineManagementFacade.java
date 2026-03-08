package PractiseLLD.airlineManagementSystem.facade;

import PractiseLLD.airlineManagementSystem.enums.FlightStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatType;
import PractiseLLD.airlineManagementSystem.model.*;
import PractiseLLD.airlineManagementSystem.service.BookingService;
import PractiseLLD.airlineManagementSystem.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

public class AirlineManagementFacade {
    private final BookingService bookingService;
    private final FlightService flightService;

    public AirlineManagementFacade(FlightService flightService, BookingService bookingService) {
        this.flightService    = flightService;
        this.bookingService   = bookingService;
    }

    public void addFlight(Flight flight) {
        flightService.addFlight(flight);
    }

    public List<Flight> searchFlights(String origin, String destination, LocalDateTime date) {
        return flightService.search(origin, destination, date);
    }

    public void updateFlightStatus(Flight flight, FlightStatus status) {
        flightService.updateStatus(flight, status);
    }

    public Booking bookFlight(Passenger passenger,Flight flight, List<Seat> seats){
        return bookingService.bookFlight(passenger,flight,seats);
    }

    public List<Seat> getAvailableSeats(Flight flight, SeatType seatClass) {
        return flightService.getAvailableSeats(flight,seatClass);
    }

    public Booking getBooking(String bookingId) {
        return bookingService.getById(bookingId);
    }

    public BoardingPass checkIn(String bookingId) {
        return bookingService.checkIn(bookingId);
    }
}
