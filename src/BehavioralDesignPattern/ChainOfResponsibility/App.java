package BehavioralDesignPattern.ChainOfResponsibility;

public class App {
    public static void main(String[] args) {
        // Build the handler chain using Builder pattern
        Handler chain = new AuthHandler();
        chain.setNext(new ValidationHandler())
                .setNext(new RateLimitHandler())
                .setNext(new OrderHandler());


        // Sample requests
        System.out.println(" Request 1:");
        Request req1 = new Request("admin", "secret", "192.168.1.1", "buy-shoes");
        chain.handleReq(req1); // All passed

        System.out.println("Request 2 (wrong password):");
        Request req2 = new Request("admin", "wrong", "192.168.1.1", "buy-shoes");
        chain.handleReq(req2); //  Auth failed

        System.out.println("Request 3 (empty payload):");
        Request req3 = new Request("admin", "secret", "192.168.1.1", "");
        chain.handleReq(req3); // Validation failed
    }
}
