package PractiseLLD.airlineManagementSystem.model;

import PractiseLLD.airlineManagementSystem.enums.FlightStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatType;
import PractiseLLD.airlineManagementSystem.observer.FlightObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private final long id;
    private final String flightNumber;
    private final Aircraft aircraft;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FlightStatus status;
    private List<FlightObserver> observers;

    public Flight(long id,String flightNumber,Aircraft aircraft){
        this.id = id;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.status = FlightStatus.SCHEDULED;
        this.observers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
        if(status == FlightStatus.DELAYED){
            for(FlightObserver observer : observers){
                observer.updateFlight(this);
            }
        }
    }

    public List<FlightObserver> getObservers() {
        return observers;
    }

    public void addObserver(FlightObserver observers) {
        this.observers.add(observers);
    }

    public List<Seat> getAvailableSeats(SeatType type) {
        List<Seat> seats = new ArrayList<>();

        aircraft.getSeats().forEach(seat -> {
            if(seat.getType().equals(type) && seat.getStatus() == SeatStatus.Available){
                seats.add(seat);
            }
        });

        return seats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", status=" + status +
                '}';
    }
}
