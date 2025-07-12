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

    private boolean validateCredentials() {
        System.out.println("Validating credentials of NetBanking");
        return !username.isBlank() && !password.isBlank();
    }
}
