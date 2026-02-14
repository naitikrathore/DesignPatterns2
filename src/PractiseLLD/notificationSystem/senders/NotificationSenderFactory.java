package PractiseLLD.notificationSystem.senders;

import PractiseLLD.notificationSystem.model.NotificationType;

/**
 * Factory for creating appropriate NotificationSender instances based on notification type.
 * Uses the Factory Pattern to encapsulate sender creation logic.
 */
public class NotificationSenderFactory {
    private NotificationSenderFactory() {}

    /**
     * Creates and returns the appropriate sender for the given notification type.
     * 
     * @param type the type of notification to send
     * @return the appropriate NotificationSender implementation
     */
    public static NotificationSender getInstance(NotificationType type) {
        return switch (type) {
            case SMS -> new SmsSender();
            case EMAIL -> new EmailSender();
            case PUSH -> new PushSender();
        };
    }
}
