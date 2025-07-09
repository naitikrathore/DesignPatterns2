package BehavioralDesignPattern.ChainOfResponsibility;

public class Request {
    String username;
    String password;
    String ip;
    String payload;

    public Request(String username, String password, String ip, String payload){
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.payload = payload;
    }
}
