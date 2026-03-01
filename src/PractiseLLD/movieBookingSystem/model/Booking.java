package PractiseLLD.movieBookingSystem.model;

import java.util.List;

public record Booking (
        long id,
        User user,
        Show show,
        Payment payment,
        List<Seat> seats
){}