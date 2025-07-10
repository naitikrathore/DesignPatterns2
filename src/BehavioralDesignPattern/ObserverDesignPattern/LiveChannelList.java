package BehavioralDesignPattern.ObserverDesignPattern;

import java.util.List;

/**
 * LiveChannelList is another concrete implementation of Observer.
 * It reacts to changes in channel data by printing the updated list.
 */
public class LiveChannelList implements Observer {
    @Override
    public void update(List<String> channels) {
        System.out.println("Got updated channel data in LiveChannelList:");
        for (String channel : channels) {
            System.out.println(channel);
        }
    }
}
