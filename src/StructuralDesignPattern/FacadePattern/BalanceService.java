package StructuralDesignPattern.FacadePattern;

/**
 * Subsystem 2: Checks if the sender has sufficient balance.
 * This would typically query the account balance from the database.
 */
public class BalanceService {
    public boolean checkSufficientBalance(String accountId, double amount) {
        System.out.println("Checking balance for: " + accountId);
        // Placeholder logic — always returns true for simplicity
        return true;
    }
}
