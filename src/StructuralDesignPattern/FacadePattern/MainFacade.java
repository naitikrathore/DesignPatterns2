package StructuralDesignPattern.FacadePattern;

/**
 * Client code demonstrating the use of the Facade.
 * The client only interacts with the Facade (BankTransferFacade)
 * and does not need to worry about internal subsystems like
 * AccountService, BalanceService, FraudService, etc.
 */
public class MainFacade {
    public static void main(String[] args) {
        BankTransferFacade bankingService = new BankTransferFacade();

        // First attempt - will fail due to fraud detection logic
        bankingService.transferFunds("132", "342", 2000000);

        System.out.println("------------------");

        // Second attempt - should succeed
        bankingService.transferFunds("132", "342", 5000);
    }
}
