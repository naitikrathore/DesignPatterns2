package PractiseLLD.notificationSystem;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.model.NotificationType;
import PractiseLLD.notificationSystem.senders.NotificationSender;
import PractiseLLD.notificationSystem.senders.NotificationSenderFactory;

import java.util.concurrent.CompletableFuture;

/**
 * Main service for sending notifications.
 * Orchestrates the notification sending process using appropriate senders and dispatcher.
 */
public class NotificationService {
    private final NotificationDispatcher notificationDispatcher;

    public NotificationService(NotificationDispatcher notificationDispatcher) {
        if (notificationDispatcher == null) {
            throw new IllegalArgumentException("NotificationDispatcher cannot be null");
        }
        this.notificationDispatcher = notificationDispatcher;
    }

    /**
     * Sends a notification asynchronously.
     * 
     * @param notification the notification to send
     * @return CompletableFuture containing the result
     * @throws IllegalArgumentException if notification is null
     */
    public CompletableFuture<NotificationResult> sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }

        System.out.println("NotificationService: Processing notification ID " + notification.id() + 
                         " of type " + notification.type());
        
        NotificationType type = notification.type();
        NotificationSender sender = NotificationSenderFactory.getInstance(type);

        return notificationDispatcher.dispatch(sender, notification);
    }

    public boolean shutdown(long timeoutSeconds) {
        return notificationDispatcher.shutdown(timeoutSeconds);
    }
}
