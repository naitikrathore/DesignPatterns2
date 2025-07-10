package BehavioralDesignPattern.ObserverDesignPattern;

import java.util.List;

/**
 * Observer interface in the Observer Design Pattern.
 * All concrete observers implement this to receive updates from the subject.
 */
public interface Observer {
    void update(List<String> channels);
}
