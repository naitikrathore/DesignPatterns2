package PractiseLLD.airlineManagementSystem.strategy;

import PractiseLLD.airlineManagementSystem.model.Flight;
import PractiseLLD.airlineManagementSystem.model.Seat;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DynamicPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Flight flight, Seat seat) {
        double price = seat.getBasePrice() * switch (seat.getType()) {
            case Economy     -> 1.0;
            case Business    -> 2.5;
        };

        long hoursLeft = ChronoUnit.HOURS.between(LocalDateTime.now(), flight.getDepartureTime());

        if (hoursLeft <= 24) {
            price *= 1.5;
            System.out.println("[DYNAMIC] Last-minute surge +50%. Hours to departure: " + hoursLeft);
        } else if (hoursLeft <= 72) {
            price *= 1.2;
            System.out.println("[DYNAMIC] Near-departure surge +20%. Hours to departure: " + hoursLeft);
        }

        int availableSeats = flight.getAvailableSeats(seat.getType()).size();

        if (availableSeats < 5) {
            price *= 1.3;
            System.out.println("[DYNAMIC] Low inventory surge +30%. Seats left: " + availableSeats);
        }

        return Math.round(price * 100.0) / 100.0;
    }

    @Override
    public String getName() {
        return "DYNAMIC";
    }
}
