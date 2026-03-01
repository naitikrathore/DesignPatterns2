package PractiseLLD.movieBookingSystem.model;

import java.util.List;

public class Screen {
    long id;
    String screenNumber;
    List<Seat> seats;

    public Screen(long id, String screenNumber, List<Seat> seats) {
        this.id = id;
        this.screenNumber = screenNumber;
        this.seats = seats;
    }
    public long getId() {
        return id;
    }
    public String getScreenNumber() {
        return screenNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
    }
}
