package CreationalDesignPattern.SingletonDesignPattern;

/**
 * Bill Pugh Singleton Implementation
 * - Uses inner static class for lazy initialization
 * - Thread-safe without synchronization
 * - Best approach for most scenarios
 */
public class BIllPughSingleton {

    private BIllPughSingleton(){
        System.out.println("BillPughSingleton instance created");

        //Add Protection Against Reflection
        if (SingletonHelper.INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
    }

    // Inner static class NOT loaded until getInstance() is called
    // JVM guarantees that static class initialization is thread-safe
    private static class SingletonHelper{
        private static final BIllPughSingleton INSTANCE = new BIllPughSingleton();
    }

    public static BIllPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void doSome(){
        System.out.println("Doing something with BillPughSingleton");
    }
}
