package PractiseLLD.airlineManagementSystem.service;

import PractiseLLD.airlineManagementSystem.enums.FlightStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatType;
import PractiseLLD.airlineManagementSystem.model.Flight;
import PractiseLLD.airlineManagementSystem.model.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlightService {
    private final Map<Long, Flight> flights = new ConcurrentHashMap<>();

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        flights.put(flight.getId(), flight);
    }

    public List<Flight> search(String origin, String destination, LocalDateTime date) {
        if (origin == null || destination == null || date == null) {
            throw new IllegalArgumentException("Origin, destination and date are required");
        }

        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights.values()) {
            boolean sameRoute = origin.equalsIgnoreCase(flight.getSource())
                    && destination.equalsIgnoreCase(flight.getDestination());
            boolean sameDay = flight.getDepartureTime() != null
                    && flight.getDepartureTime().toLocalDate().equals(date.toLocalDate());

            if (sameRoute && sameDay && flight.getStatus() != FlightStatus.CANCELLED) {
                result.add(flight);
            }
        }
        return result;
    }

    public void updateStatus(Flight flight, FlightStatus status) {
        if (flight == null || status == null) {
            throw new IllegalArgumentException("Flight and status are required");
        }
        flight.setStatus(status);
    }

    public List<Seat> getAvailableSeats(Flight flight, SeatType seatClass) {
        if (flight == null || seatClass == null) {
            throw new IllegalArgumentException("Flight and seatClass are required");
        }
        return flight.getAvailableSeats(seatClass);
    }
}
