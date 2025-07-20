package MultiThreading;

public class SharedResource {
    public boolean itemAvailable = false;

    public synchronized void addItem(){
        System.out.println("addItem ");
        itemAvailable = true;
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Inside consume item, is available to consume: " + itemAvailable);

        while(!itemAvailable) {
            try {
                System.out.println("Consume item not available to consume; applied wait()");
                wait();
                System.out.println("Consume item may be available to consume; wait released by notify()");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("item consumed");
        itemAvailable = false;
    }
}
