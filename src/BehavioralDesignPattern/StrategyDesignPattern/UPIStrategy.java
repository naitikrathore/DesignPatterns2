package BehavioralDesignPattern.StrategyDesignPattern;

class UPIStrategy implements PaymentStrategy{
    String upiId;
    String pin;

    UPIStrategy(String upiId, String pin){
        this.upiId = upiId;
        this.pin = pin;

    }
    @Override
    public void processPayment(double amount) {
        if(validateCredentials()){
            System.out.println("Payment done, Mode: UPI");
        }
    }

    public void accessOnlyForConcreteClassObject(){
        //Note:
        // to access this you need to create object of this concrete class using the reference of this class only
        // if you create object of this class using reference of interface type then methods of interface only will accessible,=.
    }

    private boolean validateCredentials() {
        System.out.println("Validating credentials of UpiMode");
        return !upiId.isBlank() && !pin.isBlank();
    }
}
