package PractiseLLD.movieBookingSystem.strategy;

import PractiseLLD.movieBookingSystem.model.Payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public Payment pay(double amount) {
        System.out.println("Credit Card Payment");
        return new Payment(1,amount,this);
    }
}
