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

    private boolean validateCredentials() {
        System.out.println("Validating credentials of UpiMode");
        return !upiId.isBlank() && !pin.isBlank();
    }
}
