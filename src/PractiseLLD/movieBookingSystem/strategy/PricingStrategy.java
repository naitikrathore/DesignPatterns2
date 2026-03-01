package PractiseLLD.movieBookingSystem.strategy;

import PractiseLLD.movieBookingSystem.model.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Seat> seats);
}
