package PractiseLLD.movieBookingSystem.model;


import PractiseLLD.movieBookingSystem.enums.PaymentStatus;
import PractiseLLD.movieBookingSystem.strategy.PaymentStrategy;

public class Payment {
    long id;
    double amount;
    PaymentStrategy strategy;
    PaymentStatus status;

    public Payment(long id, double amount, PaymentStrategy strategy) {
        this.id = id;
        this.amount = amount;
        this.strategy = strategy;
        status = PaymentStatus.PENDING;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
