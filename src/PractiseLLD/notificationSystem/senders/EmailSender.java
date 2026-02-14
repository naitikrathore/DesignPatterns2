package PractiseLLD.notificationSystem.senders;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.model.NotificationType;

/**
 * Sends notifications via email channel.
 * Simulates email delivery for demonstration purposes.
 */
public class EmailSender implements NotificationSender {
    @Override
    public NotificationResult sendNotification(Notification notification) {
        System.out.println("EmailSender: Sending email to " + notification.recipient() + 
                         " - Message: " + notification.message());
        
        // Simulate email sending - in real implementation, this would use JavaMail or similar
        // For now, we'll assume success
        return NotificationResult.success(notification.id(), NotificationType.EMAIL, 1);
    }
}
