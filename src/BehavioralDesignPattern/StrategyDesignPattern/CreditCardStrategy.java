package BehavioralDesignPattern.StrategyDesignPattern;

// Step 2: Concrete Strategies
class CreditCardStrategy implements PaymentStrategy{
    String cardNumber;
    String expiryDate;

    CreditCardStrategy(String cardNumber, String expiryDate){
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(double amount) {
        if(validateCredentials()){
            System.out.println("Payment done, Mode: Credit Card");
        }
    }

    public void accessOnlyForConcreteClassObject(){
        //do
    }
    private boolean validateCredentials() {
        System.out.println("Validating credentials of Credit Card");
        return cardNumber.length() >= 12 && !expiryDate.isBlank();
    }
}
