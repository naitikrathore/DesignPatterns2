package BehavioralDesignPattern.StrategyDesignPattern;

class PaymentContext {
    private PaymentStrategy paymentMode;

    PaymentContext(PaymentStrategy paymentStrategy){
        paymentMode = paymentStrategy;
    }

    void setPaymentStrategy(PaymentStrategy paymentStrategy){
        paymentMode = paymentStrategy;
    }

    void makePayment(double amount){
        if(paymentMode == null){
            throw new IllegalStateException("Payment strategy not set");
        }
        System.out.println("=== Payment Processing Started ===");
        System.out.println("Payment Method: " + paymentMode.getClass().getName());
        System.out.println("Amount: $" + amount);

        paymentMode.processPayment(amount);
        System.out.println("=== Payment Processing Completed ===");
    }
}
