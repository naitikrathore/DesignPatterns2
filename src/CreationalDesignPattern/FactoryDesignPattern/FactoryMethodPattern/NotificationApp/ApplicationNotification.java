package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.NotificationApp;

public class ApplicationNotification {
    public static void main(String[] args) {
        NotificationFactory emailSender = new EmailCreater();
        emailSender.notify("Ticket Booked, Email");
    }
}