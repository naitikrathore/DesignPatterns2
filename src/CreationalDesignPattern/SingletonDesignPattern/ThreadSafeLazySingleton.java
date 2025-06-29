package CreationalDesignPattern.SingletonDesignPattern;

/**
 * Thread-Safe Lazy Singleton using synchronized method
 * - Thread-safe but with performance overhead
 * - Synchronization on every call to getInstance()
 */
public class ThreadSafeLazySingleton {
    public static ThreadSafeLazySingleton instance;

    private ThreadSafeLazySingleton(){
        System.out.println("ThreadSafeLazySingleton instance created");
    }

    public static synchronized ThreadSafeLazySingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeLazySingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Doing something with ThreadSafeLazySingleton");
    }
}
