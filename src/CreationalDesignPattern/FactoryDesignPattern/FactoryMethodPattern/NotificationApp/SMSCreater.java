package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class SMSCreater extends NotificationFactory {
    public SMSCreater() {
    }

    protected Notification createNotification() {
        return new SMSNotification();
    }
}