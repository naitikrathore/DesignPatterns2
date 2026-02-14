package PractiseLLD.notificationSystem.senders;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;

/**
 * Interface for sending notifications through different channels.
 * Implementations should handle the actual sending logic for specific notification types.
 */
public interface NotificationSender {
    /**
     * Sends a notification through the specific channel.
     * 
     * @param notification the notification to send
     * @return NotificationResult indicating success or failure
     */
    NotificationResult sendNotification(Notification notification);
}
