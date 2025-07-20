public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("Hello " + Thread.currentThread().getName());

        Thread thread = new Thread(()-> {
            System.out.println("World " + Thread.currentThread().getName());
        });
        thread.start();
    }
}
