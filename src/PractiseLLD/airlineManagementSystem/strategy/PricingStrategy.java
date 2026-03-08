package PractiseLLD.airlineManagementSystem.strategy;

import PractiseLLD.airlineManagementSystem.model.Flight;
import PractiseLLD.airlineManagementSystem.model.Seat;

public interface PricingStrategy {
    double calculatePrice(Flight flight, Seat seat);
    String getName();
}
