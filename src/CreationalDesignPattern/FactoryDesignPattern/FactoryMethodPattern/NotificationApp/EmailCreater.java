package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class EmailCreater extends NotificationFactory {
    protected Notification createNotification() {
        return new EmailNotification();
    }
}