package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class PushCreater extends NotificationFactory {
    public PushCreater() {
    }

    protected Notification createNotification() {
        return new PushNotification();
    }
}