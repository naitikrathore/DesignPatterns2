package BehavioralDesignPattern.ChainOfResponsibility;

public class AuthHandler extends Handler{
    @Override
    public boolean handleReq(Request req) {
        if(!"admin".equals(req.username) || !"secret".equals(req.password)){
            System.out.println(" Authentication failed");
            return false;
        }
        System.out.println("Authentication passed");
        return super.handleReq(req); // pass to next
    }
}
