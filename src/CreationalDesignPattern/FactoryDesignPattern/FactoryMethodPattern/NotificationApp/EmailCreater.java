package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class EmailCreater extends NotificationFactory {
    public EmailCreater() {
    }

    protected Notification createNotification() {
        return new EmailNotification();
    }
}