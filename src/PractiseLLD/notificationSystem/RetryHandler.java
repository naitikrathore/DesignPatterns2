package PractiseLLD.notificationSystem;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.senders.NotificationSender;

/**
 * Handles retry logic for failed notification sends.
 * Implements exponential backoff strategy with configurable retry attempts.
 */
public class RetryHandler {
    private final int maxRetryCount;
    private final long retryDelayMs;

    public RetryHandler(int maxRetryCount, long retryDelayMs) {
        this.maxRetryCount = maxRetryCount;
        this.retryDelayMs = retryDelayMs;
    }

    public NotificationResult sendWithRetry(NotificationSender sender, Notification notification) {
        int attempts = 0;
        Exception lastException = null;

        System.out.println("RetryHandler: Starting send attempts for notification ID: " + notification.id());

        while (attempts < maxRetryCount) {
            attempts++;
            try {
                System.out.println("Attempt " + attempts + " of " + maxRetryCount);
                NotificationResult result = sender.sendNotification(notification);
                System.out.println("✓ Notification sent successfully on attempt " + attempts);
                return result;
            } catch (Exception e) {
                lastException = e;
                System.out.println("✗ Attempt " + attempts + " failed: " + e.getMessage());

                if (attempts >= maxRetryCount) {
                    System.out.println("Failed after " + attempts + " attempts. Giving up.");
                    break;
                }

                System.out.println("Retrying after " + retryDelayMs + "ms delay...");
                try {
                    Thread.sleep(retryDelayMs);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return NotificationResult.failure(
                        notification.id(),
                        notification.type(),
                        attempts,
                        "Retry interrupted: " + ex.getMessage()
                    );
                }
            }
        }

        // All retries exhausted
        String errorMessage = lastException != null 
            ? lastException.getMessage() 
            : "Unknown error after " + attempts + " attempts";
        
        return NotificationResult.failure(
            notification.id(),
            notification.type(),
            attempts,
            errorMessage
        );
    }
}
