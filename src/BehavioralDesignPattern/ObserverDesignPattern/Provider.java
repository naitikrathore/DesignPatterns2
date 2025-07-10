package BehavioralDesignPattern.ObserverDesignPattern;

/**
 * Provider interface defines the Subject in the Observer Design Pattern.
 * All concrete subjects must implement methods to attach, detach,
 * and notify observers.
 */
public interface Provider {
    void attachObserver(Observer obj);
    void detachObserver(Observer obj);
    void notifyObservers();
}
