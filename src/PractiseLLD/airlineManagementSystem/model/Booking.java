package PractiseLLD.airlineManagementSystem.model;

import PractiseLLD.airlineManagementSystem.enums.BookingStatus;

import java.util.List;
import java.util.stream.Collectors;

public class Booking {
    private long id;
    private Passenger passenger;
    private Flight flight;
    private List<Seat> seats;
    private BookingStatus bookingStatus;
    private final double totalAmount;

    public Booking(Passenger passenger, Flight flight,List<Seat> seats, double totalAmount) {
        this.passenger = passenger;
        this.flight = flight;
        this.seats = seats;
        this.totalAmount = totalAmount;
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", passenger=" + passenger.getName() +
                ", flight=" + flight.getFlightNumber() +
                ", seats=" + seats.stream().map(Seat::getSeatNumber).collect(Collectors.toList()) +
                ", bookingStatus=" + bookingStatus +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
