package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class SMSNotification implements Notification {
    public SMSNotification() {
    }

    public void sendNotification(String message) {
        System.out.println("SMSNotification " + message);
    }
}
