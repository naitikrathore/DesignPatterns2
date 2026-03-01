package PractiseLLD.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    public int floorNumber;
    private final List<Slot> slots = new ArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public Slot findAvailableSlotForVehicle(Vehicle vehicle) {
        System.out.println("slots" + slots.size());
        return slots.stream()
                .filter(slot -> slot.supportsVehicleType(vehicle.getType()) && slot.isAvailable())
                .findFirst()
                .orElse(null);
    }

}
