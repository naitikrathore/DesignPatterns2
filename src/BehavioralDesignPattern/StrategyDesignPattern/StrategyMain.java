package BehavioralDesignPattern.StrategyDesignPattern;

public class StrategyMain {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardStrategy("4568 3485 2384", "03/2030");
        PaymentContext paymentHandler = new PaymentContext(creditCard);
        paymentHandler.makePayment(1000.00);

        UPIStrategy upi = new UPIStrategy("9199271506@sbi","1234");
        paymentHandler.setPaymentStrategy(upi);
        paymentHandler.makePayment(2000.00);

        NetBankingStrategy netBanking = new NetBankingStrategy("naitik1234","12345678");
        paymentHandler.setPaymentStrategy(netBanking);
        paymentHandler.makePayment(5000.00);
    }
}
