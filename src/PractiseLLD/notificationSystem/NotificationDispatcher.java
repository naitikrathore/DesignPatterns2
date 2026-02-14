package PractiseLLD.notificationSystem;

import PractiseLLD.notificationSystem.model.Notification;
import PractiseLLD.notificationSystem.model.NotificationResult;
import PractiseLLD.notificationSystem.senders.NotificationSender;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Dispatches notifications asynchronously using a thread pool.
 * Handles the async execution of notification sending with retry logic.
 */
public class NotificationDispatcher {
    private final ExecutorService executorService;
    private final RetryHandler retryHandler;

    public NotificationDispatcher(RetryHandler retryHandler) {
        this(retryHandler, 5);
    }

    public NotificationDispatcher(RetryHandler retryHandler, int threadPoolSize) {
        this.retryHandler = retryHandler;
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    /**
     * Dispatches a notification asynchronously.
     * 
     * @param sender the sender to use
     * @param notification the notification to send
     * @return CompletableFuture that will contain the result
     */
    public CompletableFuture<NotificationResult> dispatch(NotificationSender sender, Notification notification) {
        System.out.println("NotificationDispatcher: Queuing notification ID " + notification.id() + " for async dispatch");
        
        return CompletableFuture.supplyAsync(() ->
                retryHandler.sendWithRetry(sender, notification), executorService
        );
    }

    /**
     * Gracefully shuts down the dispatcher.
     * Waits for pending tasks to complete before shutting down.
     * 
     * @param timeoutSeconds timeout in seconds to wait for tasks
     * @return true if shutdown completed successfully, false if timeout occurred
     */
    public boolean shutdown(long timeoutSeconds) {
        System.out.println("NotificationDispatcher: Initiating graceful shutdown...");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(timeoutSeconds, TimeUnit.SECONDS)) {
                System.out.println("NotificationDispatcher: Timeout elapsed, forcing shutdown");
                executorService.shutdownNow();
                return false;
            }
            System.out.println("NotificationDispatcher: Shutdown completed successfully");
            return true;
        } catch (InterruptedException e) {
            System.out.println("NotificationDispatcher: Shutdown interrupted, forcing shutdown");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
