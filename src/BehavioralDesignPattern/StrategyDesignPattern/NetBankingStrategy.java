package BehavioralDesignPattern.StrategyDesignPattern;

// Step 2: Concrete Strategies
class NetBankingStrategy implements PaymentStrategy{
    String username;
    String password;

    NetBankingStrategy(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public void processPayment(double amount) {
        if(validateCredentials()){
            System.out.println("Payment done, Mode: NetBanking");
        }
    }

    public void accessOnlyForConcreteClassObject(){
        //Note:
        // to access this you need to create object of this concrete class using the reference of this class only
        // if you create object of this class using reference of interface type then methods of interface only will accessible,=.
    }

    private boolean validateCredentials() {
        System.out.println("Validating credentials of NetBanking");
        return !username.isBlank() && !password.isBlank();
    }
}
