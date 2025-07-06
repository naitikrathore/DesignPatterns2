package StructuralDesignPattern.FacadePattern;

/**
 * Subsystem 4: Executes the actual transfer of funds.
 * Would typically update databases, generate transaction IDs, etc.
 */
public class TransferService {
    public void transfer(String from, String to, double amount) {
        System.out.println("Transferred ₹" + amount + " from " + from + " to " + to);
    }
}
