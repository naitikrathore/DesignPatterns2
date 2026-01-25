package CreationalDesignPattern.SingletonDesignPattern;

public class ThreadSafeOptimizedSingleton {
    private ThreadSafeOptimizedSingleton() {/*Do not allow to create instance with new keyword*/}

    /**
     * Volatile prevents:
     * 1. Instruction reordering during object creation
     * 2. Other threads seeing a partially constructed object
     */
    private static volatile ThreadSafeOptimizedSingleton threadSafeOptimizedSingleton;

    /**
     * Returns the singleton instance.
     * First null check:
     * - Improves performance by avoiding synchronization once the instance exists.
     * Synchronized block:
     * - Ensures only one thread can create the instance at a time.
     * Second null check (CRITICAL):
     * - Multiple threads can pass the first null check simultaneously.
     * - While one thread is creating the instance, others wait for the lock.
     * - When waiting threads enter the synchronized block, the instance
     *   may already be created.
     * - This check ensures only one instance is created.
     *
     * @return the single instance of {@link ThreadSafeOptimizedSingleton}
     */
    public static ThreadSafeOptimizedSingleton getInstance() {
        if(threadSafeOptimizedSingleton == null){
            synchronized (ThreadSafeOptimizedSingleton.class){
                //why again this check because if some thread is waiting here instead of function first line
                if(threadSafeOptimizedSingleton == null){
                    threadSafeOptimizedSingleton = new ThreadSafeOptimizedSingleton();
                }
            }
        }

        return threadSafeOptimizedSingleton;
    }
}
