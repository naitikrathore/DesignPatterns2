package BehavioralDesignPattern.ObserverDesignPattern;

import java.util.List;

/**
 * EpgChannelList is a concrete implementation of Observer.
 * It reacts to updates from the subject by printing the channel list to the console.
 */
public class EpgChannelList implements Observer {
    @Override
    public void update(List<String> channels) {
        System.out.println("Got updated channel data in EpgChannelList:");
        for (String channel : channels) {
            System.out.println(channel);
        }
    }
}
