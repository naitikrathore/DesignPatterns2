package PractiseLLD.notificationSystem;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.model.NotificationType;

import java.util.concurrent.CompletableFuture;

/**
 * Client demonstration of the Notification System.
 * Shows how to send notifications and handle results properly.
 */
public class NotificationClient {
    public static void main(String[] args) {
        // Initialize components
        RetryHandler retryHandler = new RetryHandler(3, 1000);
        NotificationDispatcher notificationDispatcher = new NotificationDispatcher(retryHandler);
        NotificationService notificationService = new NotificationService(notificationDispatcher);

        System.out.println("=== Notification System Demo ===\n");

        // Example 1: Send an email notification
        Notification emailNotification = new Notification(
                1,
                NotificationType.EMAIL,
                "Get 50% discount on your next food order!",
                "naitik@example.com"
        );

        CompletableFuture<NotificationResult> emailFuture = 
            notificationService.sendNotification(emailNotification);

        // Example 2: Send an SMS notification
        Notification smsNotification = new Notification(
                2,
                NotificationType.SMS,
                "Your OTP is 123456",
                "+1234567890"
        );

        CompletableFuture<NotificationResult> smsFuture = 
            notificationService.sendNotification(smsNotification);

        // Example 3: Send a push notification
        Notification pushNotification = new Notification(
                3,
                NotificationType.PUSH,
                "New message from John Doe",
                "user_device_token_123"
        );

        CompletableFuture<NotificationResult> pushFuture = 
            notificationService.sendNotification(pushNotification);

        // Wait for all notifications to complete and print results
        System.out.println("\n=== Waiting for notifications to complete ===\n");

        CompletableFuture.allOf(emailFuture, smsFuture, pushFuture)
            .thenRun(() -> {
                System.out.println("\n=== Notification Results ===");
                
                emailFuture.thenAccept(result -> {
                    System.out.println("Email Result: " + result);
                }).join();

                smsFuture.thenAccept(result -> {
                    System.out.println("SMS Result: " + result);
                }).join();

                pushFuture.thenAccept(result -> {
                    System.out.println("Push Result: " + result);
                }).join();

                System.out.println("\n=== All notifications processed ===");
            })
            .join();

        // Graceful shutdown
        System.out.println("\n=== Shutting down notification service ===");
        boolean shutdownSuccess = notificationService.shutdown(10);
        
        if (shutdownSuccess) {
            System.out.println("✓ Service shutdown successfully");
        } else {
            System.out.println("✗ Service shutdown timed out");
        }
    }
}
