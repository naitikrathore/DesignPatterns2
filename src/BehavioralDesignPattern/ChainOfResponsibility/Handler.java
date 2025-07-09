package BehavioralDesignPattern.ChainOfResponsibility;

abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler handler){
        this.nextHandler = handler;
        return this.nextHandler;
    }

    public boolean handleReq(Request req){
        if(nextHandler != null){
            System.out.println("next handler " + nextHandler.getClass().getName());
            nextHandler.handleReq(req);
        }
        return true;
    }
}
