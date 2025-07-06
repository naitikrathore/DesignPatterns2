package StructuralDesignPattern.FacadePattern;

/**
 * Subsystem 3: Performs fraud detection checks.
 * In real systems, this might use machine learning or rule-based engines.
 */
public class FraudService {
    public boolean checkForFraud(String accountNumber, double amount, String location) {
        System.out.println("Running fraud detection for account: " + accountNumber);
        // Simple fraud logic: block transfers over ₹100,000
        return amount < 100000;
    }
}
