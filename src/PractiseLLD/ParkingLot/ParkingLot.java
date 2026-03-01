package PractiseLLD.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private final List<Floor> floors = new ArrayList<>();

    private ParkingLot(){};

    public synchronized static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }

        return parkingLot;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        System.out.println("floors " + floors.size());
        for(Floor floor : floors) {
            Slot slot = floor.findAvailableSlotForVehicle(vehicle);
            if (slot != null) {
                slot.bookSlot(vehicle);
                return new Ticket(1, vehicle, slot);
            }
        }
        throw new IllegalArgumentException("No slot available");
    }
}
