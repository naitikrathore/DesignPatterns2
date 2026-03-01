package PractiseLLD.movieBookingSystem.service;

import PractiseLLD.movieBookingSystem.enums.PaymentStatus;
import PractiseLLD.movieBookingSystem.model.*;
import PractiseLLD.movieBookingSystem.strategy.PaymentStrategy;
import PractiseLLD.movieBookingSystem.strategy.PricingStrategy;

import java.util.List;
import java.util.Optional;

public class BookingService {
    private final SeatLockService seatLockService;
    private final PricingStrategy pricingStrategy;

    public BookingService(SeatLockService seatLockService, PricingStrategy pricingStrategy) {
        this.seatLockService = seatLockService;
        this.pricingStrategy = pricingStrategy;
    }

    public Optional<Booking> bookShow(User user, Show show, List<Seat> seats, PaymentStrategy paymentStrategy) {
        seatLockService.lockSeats(user.getId(), show,seats);

        double totalAmount = pricingStrategy.calculatePrice(seats);

        Payment payment = paymentStrategy.pay(totalAmount);

        if (payment.getStatus() == PaymentStatus.SUCCESS) {
            System.out.println("Payment Successful");
            seatLockService.bookLockedSeats(user.getId(), show);

            Booking booking = new  Booking(1,user,show,payment,seats);

            return Optional.of(booking);
        }else{
            System.out.println("Payment failed return " + Optional.empty());
            return Optional.empty();
        }
    }
}
