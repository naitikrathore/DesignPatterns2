package PractiseLLD.airlineManagementSystem.observer;

import PractiseLLD.airlineManagementSystem.model.Flight;

public class PassengerNotifier implements FlightObserver {
    @Override
    public void updateFlight(Flight flight) {
        System.out.println("[NOTIFIER] Flight status changed: " + flight);
    }
}
