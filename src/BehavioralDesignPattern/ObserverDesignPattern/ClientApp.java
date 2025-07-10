package BehavioralDesignPattern.ObserverDesignPattern;

import java.util.Arrays;

public class ClientApp {
    public static void main(String[] args) {
        // Concrete observers
        EpgChannelList epgChannelList = new EpgChannelList();
        LiveChannelList liveChannelList = new LiveChannelList();

        // Concrete subject
        ChannelDataHandler channelDataHandler = new ChannelDataHandler();

        // Register observers
        channelDataHandler.attachObserver(epgChannelList);
        channelDataHandler.attachObserver(liveChannelList);

        // Update channel list - both observers will be notified
        channelDataHandler.updateChannelList(Arrays.asList("Sony Max", "Star Gold"));

        // Detach one observer
        channelDataHandler.detachObserver(epgChannelList);

        // Update channel list again - only LiveChannelList will be notified
        channelDataHandler.updateChannelList(Arrays.asList("Cartoon Network", "Pogo"));
    }
}
