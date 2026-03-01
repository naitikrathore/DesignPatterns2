package PractiseLLD.movieBookingSystem.strategy;

import PractiseLLD.movieBookingSystem.enums.SeatType;
import PractiseLLD.movieBookingSystem.model.Seat;

import java.util.List;

public class GeneralStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Seat> seats) {
        System.out.println("Calculating GeneralStrategy price for seats");
        SeatType type = seats.getFirst().getType();

        return switch (type){
            case GOLD -> 100;
            case SILVER -> 100;
        };
    }
}
