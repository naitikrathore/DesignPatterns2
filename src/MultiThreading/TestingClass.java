package MultiThreading;

import javax.swing.plaf.TableHeaderUI;
import java.util.function.Consumer;

/**
 * TestingClass demonstrates multi-threaded behavior with object-level locks.
 */
public class TestingClass {
    public static void main(String[] args) {
        // Create an instance of MonitorLockExample which holds the synchronized methods
//        MonitorLockExample obj =  new MonitorLockExample();
//
//        // Create three threads:
//        // thread1 will run synchronized method task1()
//        Thread thread1 = new Thread(obj::task1);
//
//        // thread2 will run task2(int a). Only part of this method is synchronized.
//        Thread thread2 = new Thread(() -> {
//            obj.task2(3);
//        });
//
//        // thread3 will run task3(), which has no synchronization and just prints a message.
//        Thread thread3 = new Thread(obj::task3);
//
////        // Start all threads. Note: Start order is not execution order!
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
//        MonitorLockExample obj2 =  new MonitorLockExample();
//        Thread threadE2 = new Thread(() -> {
//            obj2.task2(4);
//        });
//        thread1.start();
//        threadE2.start();

        // Note: Output order may appear as below depending on thread scheduling.
        /*
        Possible Output Order:
        Executing Task 1 before sleep   // from thread1, enters synchronized method and sleeps
        Executing Task 2 without synchronized   // thread2 starts, prints before entering synchronization
        Executing Task 3                        // thread3 runs, prints immediately
        Executing Task 1 after sleep            // thread1 wakes, finishes
        Executing Task 2 after synchronized a value: 3 // thread2 enters synchronized block after task1 is done
         */

        /** Below for class SharedResource.*/

        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(() ->{
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            resource.addItem();
        });
        Thread consumerThread = new Thread(resource::consumeItem);
        System.out.println("ProducerThread started");
        producerThread.start();
        System.out.println("Consumer Thread started");
        consumerThread.start();

    }
}
