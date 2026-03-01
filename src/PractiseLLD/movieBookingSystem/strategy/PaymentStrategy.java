package PractiseLLD.movieBookingSystem.strategy;

import PractiseLLD.movieBookingSystem.model.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
