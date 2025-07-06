package StructuralDesignPattern.FacadePattern;

/**
 *  Client code without using the Facade pattern.
 * The client must manually call every subsystem in the correct order.
 *
 * ️ Problems:
 * - Client is tightly coupled to all subsystems.
 * - Code is hard to maintain, reuse, and test.
 * - Violates Single Responsibility Principle (SRP).
 */
public class ProblemWithoutFacade {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.validateAccount("123");

        BalanceService balanceService = new BalanceService();
        balanceService.checkSufficientBalance("123", 5000);

        FraudService fraudService = new FraudService();
        fraudService.checkForFraud("123", 5000,"Mumbai");

        TransferService transferService = new TransferService();
        transferService.transfer("123", "456", 5000);

        NotificationService notificationService = new NotificationService();
        notificationService.sendSMS("123", "456");
    }
}
