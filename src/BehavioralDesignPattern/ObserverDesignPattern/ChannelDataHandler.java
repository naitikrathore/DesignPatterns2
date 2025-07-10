package BehavioralDesignPattern.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * ChannelDataHandler acts as the Subject in the Observer pattern.
 * It maintains a list of observers and notifies them whenever the channel list changes.
 */
public class ChannelDataHandler implements Provider {
    List<Observer> observers = new ArrayList<>();
    List<String> channels = new ArrayList<>();

    // Attach an observer to the list
    @Override
    public void attachObserver(Observer obj) {
        System.out.println("Observer added: " + obj.toString());
        observers.add(obj);
    }

    // Detach an observer from the list
    @Override
    public void detachObserver(Observer obj) {
        System.out.println("Observer removed: " + obj.getClass().getName());
        observers.remove(obj);
    }

    // Update the internal channel list and notify all observers
    public void updateChannelList(List<String> newChannels) {
        System.out.println("New channels added to ChannelDataHandler");
        this.channels.addAll(new ArrayList<>(newChannels)); // Create copy for safety
        notifyObservers(); // Notify all subscribed observers
    }

    // Notify each observer with the latest list of channels
    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(channels);
        }
    }
}
