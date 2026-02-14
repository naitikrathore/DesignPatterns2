package PractiseLLD.notificationSystem.senders;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.model.NotificationType;

/**
 * Sends notifications via SMS channel.
 * Simulates SMS delivery for demonstration purposes.
 */
public class SmsSender implements NotificationSender {
    @Override
    public NotificationResult sendNotification(Notification notification) {
        System.out.println("SmsSender: Sending SMS to " + notification.recipient() + 
                         " - Message: " + notification.message());
        
        // Simulate SMS sending - in real implementation, this would use Twilio or similar
        // For now, we'll assume success
        return NotificationResult.success(notification.id(), NotificationType.SMS, 1);
    }
}
