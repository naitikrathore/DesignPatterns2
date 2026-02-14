package PractiseLLD.notificationSystem.model;

/**
 * Represents a notification to be sent.
 * 
 * @param id unique identifier for the notification
 * @param type the type/channel of notification (EMAIL, SMS, PUSH)
 * @param message the content of the notification
 * @param recipient the recipient identifier (email, phone, device token, etc.)
 */
public record Notification(
        long id,
        NotificationType type,
        String message,
        String recipient
) { }
