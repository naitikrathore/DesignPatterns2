package BehavioralDesignPattern.ChainOfResponsibility;

public class ValidationHandler extends Handler{
    @Override
    public boolean handleReq(Request req) {
        if (req.payload == null || req.payload.trim().isEmpty()) {
            System.out.println("Invalid request payload");
            return false;
        }
        System.out.println("✅ Payload validated");
        return super.handleReq(req);
    }
}
