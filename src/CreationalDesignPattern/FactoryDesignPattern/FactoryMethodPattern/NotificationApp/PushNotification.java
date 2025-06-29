package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class PushNotification implements Notification {
    public PushNotification() {
    }

    public void sendNotification(String message) {
        System.out.println("EmailNotification " + message);
    }
}

