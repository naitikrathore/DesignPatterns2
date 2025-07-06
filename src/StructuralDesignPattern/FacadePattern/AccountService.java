package StructuralDesignPattern.FacadePattern;

/**
 * Subsystem 1: Handles account validation logic.
 * Could involve checking account status, activation, KYC, etc.
 */
public class AccountService {
    public boolean validateAccount(String accountNumber) {
        System.out.println("Validating account: " + accountNumber);
        // Placeholder for actual validation logic
        return true;
    }
}
