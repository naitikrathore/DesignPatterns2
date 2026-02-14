package PractiseLLD.notificationSystem.model;

import java.time.Instant;

/**
 * Represents the result of a notification send operation.
 * Contains status information, timestamps, and error details if applicable.
 */
public class NotificationResult {
    private final long notificationId;
    private final NotificationType type;
    private final boolean success;
    private final int attemptCount;
    private final Instant timestamp;
    private final String errorMessage;

    private NotificationResult(long notificationId, NotificationType type, boolean success, 
                               int attemptCount, Instant timestamp, String errorMessage) {
        this.notificationId = notificationId;
        this.type = type;
        this.success = success;
        this.attemptCount = attemptCount;
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
    }

    /**
     * Creates a successful notification result.
     */
    public static NotificationResult success(long notificationId, NotificationType type, int attemptCount) {
        return new NotificationResult(notificationId, type, true, attemptCount, Instant.now(), null);
    }

    /**
     * Creates a failed notification result.
     */
    public static NotificationResult failure(long notificationId, NotificationType type, 
                                             int attemptCount, String errorMessage) {
        return new NotificationResult(notificationId, type, false, attemptCount, Instant.now(), errorMessage);
    }

    @Override
    public String toString() {
        return "NotificationResult{" +
                "id=" + notificationId +
                ", type=" + type +
                ", success=" + success +
                ", attempts=" + attemptCount +
                ", timestamp=" + timestamp +
                (errorMessage != null ? ", error='" + errorMessage + '\'' : "") +
                '}';
    }
}
