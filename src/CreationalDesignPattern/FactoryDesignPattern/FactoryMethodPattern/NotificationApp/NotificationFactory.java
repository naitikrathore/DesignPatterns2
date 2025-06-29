package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public abstract class NotificationFactory {
    public NotificationFactory() {
    }

    protected abstract Notification createNotification();

    public void notify(String message) {
        Notification sender = this.createNotification();
        sender.sendNotification(message);
    }
}

