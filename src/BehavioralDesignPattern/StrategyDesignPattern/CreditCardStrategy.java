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
        //Note:
        // to access this you need to create object of this concrete class using the reference of this class only
        // if you create object of this class using reference of interface type then methods of interface only will accessible,=.
    }

    private boolean validateCredentials() {
        System.out.println("Validating credentials of Credit Card");
        return cardNumber.length() >= 12 && !expiryDate.isBlank();
    }
}
