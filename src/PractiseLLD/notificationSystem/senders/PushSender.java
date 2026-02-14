package PractiseLLD.notificationSystem.senders;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.model.NotificationType;

/**
 * Sends push notifications to mobile devices.
 * Simulates push notification delivery for demonstration purposes.
 */
public class PushSender implements NotificationSender {
    @Override
    public NotificationResult sendNotification(Notification notification) {
        System.out.println("PushSender: Sending push notification to " + notification.recipient() + 
                         " - Message: " + notification.message());
        
        // Simulate push notification - in real implementation, this would use FCM or similar
        // For now, we'll assume success
        return NotificationResult.success(notification.id(), NotificationType.PUSH, 1);
    }
}
