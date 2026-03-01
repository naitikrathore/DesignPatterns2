package PractiseLLD.movieBookingSystem.strategy;

import PractiseLLD.movieBookingSystem.enums.SeatType;
import PractiseLLD.movieBookingSystem.model.Seat;

import java.util.List;

public class SpecialOccasionStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Seat> seats) {
        System.out.println("Calculating SpecialOccasionStrategy price for seats");
        SeatType type = seats.getFirst().getType();

        return switch (type){
            case GOLD -> 300;
            case SILVER -> 200;
        };
    }
}
