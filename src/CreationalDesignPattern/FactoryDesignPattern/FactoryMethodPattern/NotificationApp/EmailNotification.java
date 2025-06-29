package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class EmailNotification implements Notification {
    public EmailNotification() {
    }

    public void sendNotification(String message) {
        System.out.println("EmailNotification " + message);
    }
}
