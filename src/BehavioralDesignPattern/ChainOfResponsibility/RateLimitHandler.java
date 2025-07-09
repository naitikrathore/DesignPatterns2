package BehavioralDesignPattern.ChainOfResponsibility;

// Step 3: Rate limiting (fake example)
public class RateLimitHandler extends Handler{
    private int attempt = 0;

    @Override
    public boolean handleReq(Request req) {
        attempt++;
        if (attempt > 3) {
            System.out.println("Rate limit exceeded");
            return false;
        }
        System.out.println("Rate check passed");
        return super.handleReq(req);
    }
}
