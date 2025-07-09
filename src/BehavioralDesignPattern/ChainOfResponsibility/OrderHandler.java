package BehavioralDesignPattern.ChainOfResponsibility;

public class OrderHandler extends Handler{
    @Override
    public boolean handleReq(Request req) {
        System.out.println("📦 Order placed for user: " + req.username);
        return true;
    }
}
