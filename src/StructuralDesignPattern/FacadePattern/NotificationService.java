package StructuralDesignPattern.FacadePattern;

/**
 * Subsystem 5: Handles customer notifications after the transfer.
 * Could involve SMS, Email, or in-app notifications.
 */
public class NotificationService {
    public void sendSMS(String fromAccount, String toAccount) {
        System.out.println("Sending SMS to " + fromAccount + ": Amount transferred to " + toAccount);
        // In real-world: integrate with SMS gateway
    }
}
