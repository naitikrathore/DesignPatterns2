package PractiseLLD.airlineManagementSystem.model;

import java.util.List;
import java.util.ArrayList;

public class Aircraft {
    private final long id;
    private final String name;
    private List<Seat> seats;

    public Aircraft(long id, String name) {
        this.id = id;
        this.name = name;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
