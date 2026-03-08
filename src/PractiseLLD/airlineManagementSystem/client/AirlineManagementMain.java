package PractiseLLD.airlineManagementSystem.client;

import PractiseLLD.airlineManagementSystem.enums.FlightStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatType;
import PractiseLLD.airlineManagementSystem.facade.AirlineManagementFacade;
import PractiseLLD.airlineManagementSystem.factory.AircraftFactory;
import PractiseLLD.airlineManagementSystem.model.Aircraft;
import PractiseLLD.airlineManagementSystem.model.BoardingPass;
import PractiseLLD.airlineManagementSystem.model.Booking;
import PractiseLLD.airlineManagementSystem.model.Flight;
import PractiseLLD.airlineManagementSystem.model.Passenger;
import PractiseLLD.airlineManagementSystem.model.Seat;
import PractiseLLD.airlineManagementSystem.observer.PassengerNotifier;
import PractiseLLD.airlineManagementSystem.service.BookingService;
import PractiseLLD.airlineManagementSystem.service.FlightService;
import PractiseLLD.airlineManagementSystem.strategy.DynamicPricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AirlineManagementMain {
    public static void main(String[] args) {
        System.out.println("=== Airline Management System Demo ===");

        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService(new DynamicPricingStrategy());
        AirlineManagementFacade facade = new AirlineManagementFacade(flightService, bookingService);

        Aircraft aircraft = AircraftFactory.createAirbusA320();

        Flight flight = new Flight(1001, "AI-202", aircraft);
        flight.setSource("DEL");
        flight.setDestination("BOM");
        flight.setDepartureTime(LocalDateTime.now().plusHours(20));
        flight.setArrivalTime(LocalDateTime.now().plusHours(22));
        flight.setStatus(FlightStatus.SCHEDULED);
        flight.addObserver(new PassengerNotifier());

        facade.addFlight(flight);
        System.out.println("[CHECK] Flight added: " + flight);

        List<Flight> foundFlights = facade.searchFlights("DEL", "BOM", flight.getDepartureTime());
        System.out.println("[CHECK] Search results count: " + foundFlights.size());
        foundFlights.forEach(f -> System.out.println(" - " + f.getFlightNumber() + " " + f.getSource() + " -> " + f.getDestination()));

        List<Seat> availableEconomy = facade.getAvailableSeats(flight, SeatType.Economy);
        System.out.println("[CHECK] Available economy seats before booking: " + availableEconomy.size());
        if (availableEconomy.size() < 2) {
            throw new IllegalStateException("Not enough seats available to run demo");
        }

        Passenger passenger1 = new Passenger(1, "Rahul", "rahul@example.com", "P1234567");
        List<Seat> seatsToBook = new ArrayList<>(availableEconomy.subList(0, 2));
        Booking booking = facade.bookFlight(passenger1, flight, seatsToBook);
        System.out.println("[CHECK] Booking created: " + booking);
        booking.getSeats().forEach(seat ->
                System.out.println("   Seat " + seat.getSeatNumber() + " status after booking: " + seat.getStatus())
        );

        Passenger passenger2 = new Passenger(2, "Amit", "amit@example.com", "P7654321");
        try {
            facade.bookFlight(passenger2, flight, List.of(seatsToBook.get(0)));
            System.out.println("[CHECK] Duplicate booking unexpectedly succeeded");
        } catch (Exception e) {
            System.out.println("[CHECK] Duplicate booking blocked as expected: " + e.getMessage());
        }

        Booking fetchedBooking = facade.getBooking(String.valueOf(booking.getId()));
        System.out.println("[CHECK] Fetched booking by id: " + fetchedBooking);

        BoardingPass boardingPass = facade.checkIn(String.valueOf(booking.getId()));
        System.out.println("[CHECK] Check-in successful");
        System.out.println("   BoardingPassId: " + boardingPass.getBoardingPassId());
        System.out.println("   FlightNumber  : " + boardingPass.getFlightNumber());
        System.out.println("   Seat          : " + boardingPass.getSeatNumber());
        System.out.println("   Gate          : " + boardingPass.getGate());
        System.out.println("   BoardingTime  : " + boardingPass.getBoardingTime());

        facade.updateFlightStatus(flight, FlightStatus.DELAYED);
        System.out.println("[CHECK] Flight status after update: " + flight.getStatus());

        List<Seat> remainingEconomy = facade.getAvailableSeats(flight, SeatType.Economy);
        System.out.println("[CHECK] Available economy seats after booking: " + remainingEconomy.size());
        System.out.println("=== Demo Completed ===");
    }
}
