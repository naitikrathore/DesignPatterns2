package StructuralDesignPattern.AdapterPattern;

/**
 * Main class
 *
 * Demonstrates how different payment providers (with different APIs)
 * can be used with a unified interface via Adapters.
 */
public class AdapterPatternMain {
    public static void main(String[] args) {
        // Use PayPal via adapter
        PayPalAPI payPalAPI = new PayPalAPI();
        PaymentGateway payPalGateway = new PayPalAPIAdapter(payPalAPI);
        PaymentProcessor payPalProcessor = new PaymentProcessor(payPalGateway);
        payPalProcessor.makePayment(500.00);

        System.out.println();

        // Use Razorpay via adapter
        RazorpayAPI razorpayAPI = new RazorpayAPI();
        PaymentGateway razorPayGateway = new RazorpayAPIAdapter(razorpayAPI);
        PaymentProcessor razorPayProcessor = new PaymentProcessor(razorPayGateway);
        razorPayProcessor.makePayment(1000.00);

    }
}
