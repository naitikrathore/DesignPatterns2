package PractiseLLD.movieBookingSystem.strategy;

import PractiseLLD.movieBookingSystem.model.Payment;

public class UPIPayment implements PaymentStrategy {
    @Override
    public Payment pay(double amount) {
        System.out.println("UPIPayment");
        return new Payment(2,amount,this);
    }
}
