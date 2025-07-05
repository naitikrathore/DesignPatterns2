package CreationalDesignPattern.SingletonDesignPattern;

/**
 * EagerSingleton Initialization
 * - Instance created when class loaded.
 * - Thread-safe by default
 * - Memory wastage if instance not used
 */
public class EagerSingleton {

    /**
     * This line is executed once when the EagerSingleton class is loaded by the classloader.
     * JVM ensures that this static initialization block is atomic and synchronized internally —
     * no two threads will see a partially constructed object or multiple instances.
     * <p>
     * Thread A requests EagerSingleton.getInstance()
     * JVM loads EagerSingleton.class into memory (if not already loaded).
     * JVM initializes the static variable INSTANCE
     */
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton(){
        System.out.println("EagerSingleton instance created at class loaded in memory.");
    }

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("Doing something with EagerSingleton");
    }
}