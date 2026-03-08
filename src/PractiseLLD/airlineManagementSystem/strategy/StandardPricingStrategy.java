package PractiseLLD.airlineManagementSystem.strategy;

import PractiseLLD.airlineManagementSystem.model.Flight;
import PractiseLLD.airlineManagementSystem.model.Seat;

import static java.lang.Math.round;

public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Flight flight, Seat seat) {
        double multiplier = switch (seat.getType()) {
            case Economy     -> 1.0;
            case Business    -> 2.5;
        };
        return round(seat.getBasePrice() * multiplier);
    }

    @Override
    public String getName() {
        return "STANDARD";
    }
}
