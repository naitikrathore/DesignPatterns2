package StructuralDesignPattern.FacadePattern;

/**
 *  FACADE CLASS
 * This class acts as a simplified interface for the client.
 * Internally, it coordinates multiple subsystems to complete a complex task (fund transfer).
 *
 *  Problem Solved:
 * - Hides complexity from client
 * - Provides a single entry point
 * - Centralizes the workflow
 * - Improves maintainability
 */
public class BankTransferFacade {
    private final AccountService accountService;
    private final BalanceService balanceService;
    private final FraudService fraudService;
    private final TransferService transferService;
    private final NotificationService notificationService;

    public BankTransferFacade() {
        accountService = new AccountService();
        balanceService = new BalanceService();
        fraudService = new FraudService();
        transferService = new TransferService();
        notificationService = new NotificationService();
    }

    /**
     * Public API for transferring funds. This method hides
     * the complex orchestration of various services and exposes
     * a single clean interface to the client.
     */
    public void transferFunds(String fromAccount, String toAccount, double amount) {
        if (!accountService.validateAccount(fromAccount) || !accountService.validateAccount(toAccount)) {
            System.out.println("Account validation failed.");
            return;
        }
        System.out.println("Account Number Check Passed");

        if (!balanceService.checkSufficientBalance(fromAccount, amount)) {
            System.out.println("Insufficient balance. Transfer aborted.");
            return;
        }
        System.out.println("Balance Check Passed");

        if (!fraudService.checkForFraud(toAccount, amount, "Mumbai")) {
            System.out.println("Fraud detected. Transfer aborted.");
            return;
        }
        System.out.println("Fraud Check Passed");

        transferService.transfer(fromAccount, toAccount, amount);
        notificationService.sendSMS(fromAccount, toAccount);
    }
}
