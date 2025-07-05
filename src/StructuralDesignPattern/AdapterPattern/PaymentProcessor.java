package StructuralDesignPattern.AdapterPattern;

//Client
//So think like initially the client does not have any third party api ,so it has only make payment.
/**
 * Client class
 *
 * Uses `PaymentGateway` interface and works seamlessly with any adapter.
 *
 * No need to know about PayPal, Razorpay, etc.
 * Demonstrates Open/Closed Principle (O in SOLID)
 */
public class PaymentProcessor {
    private final PaymentGateway paymentServiceProvider;

    public PaymentProcessor(PaymentGateway serviceProvider){
        this.paymentServiceProvider = serviceProvider;
    }
    public boolean makePayment(double amount){
        System.out.println("Payment initiated from client app: " +amount);
        paymentServiceProvider.payAmount(amount);
        return true;
    }
}
