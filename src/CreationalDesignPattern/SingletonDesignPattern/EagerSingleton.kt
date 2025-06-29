package CreationalDesignPattern.SingletonDesignPattern;

/**
 * EagerSingleton Initialization
 * - Instance created when class loaded.
 * - Thread-safe by default
 * - Memory wastage if instance not used
 */
class EagerSingleton {
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