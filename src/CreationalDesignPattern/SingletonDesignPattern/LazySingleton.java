package CreationalDesignPattern.SingletonDesignPattern;

/**
 * Lazy Initialization Singleton
 *  - Instance created when first requested,
 *  - NOT Thread-Safe
 *  - Memory efficient
 */
public class LazySingleton {
    private static LazySingleton instance;

    //make constructor private so that no one can create object using new.
    private LazySingleton(){
        System.out.println("LazySingleton instance created.");
    }

    public static LazySingleton getInstance(){
        if(instance == null){
            // Can create multiple instances in multi-threaded environment.
            instance = new LazySingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Doing something with LazySingleton");
    }
}
