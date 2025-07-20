package MultiThreading;

/**
 * This class demonstrates how Java's monitor lock (synchronized) works.
 */
public class MonitorLockExample {

    // Fully synchronized method - locks the entire object for duration.
    public synchronized void task1() {
        try {
            System.out.println("Executing Task 1 before sleep");
            Thread.sleep(3000); // Simulates a long operation while holding the lock
            System.out.println("Executing Task 1 after sleep");
        } catch (Exception e) {
            System.out.println("Exception on Task 1: " + e);
        }
    }

    /**
     * Partially synchronized method:
     *   - First part (print) runs without synchronization.
     *   - Only block inside 'synchronized(this)' requires object lock.
     *   - If another thread (task1) is holding the lock, will wait before printing 'after synchronized'.
     */
    public void task2(int a) {
        System.out.println("Executing Task 2 without synchronized");
        // Only this block is synchronized, may be blocked by another thread holding the lock (like task1)
        synchronized(this) {
            System.out.println("Executing Task 2 after synchronized a value: " + a);
        }
    }

    /**
     * No competition for any locks, so always runs immediately after being scheduled.
     */
    public void task3() {
        System.out.println("Executing Task 3");
    }
}
