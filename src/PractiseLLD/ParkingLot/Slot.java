package PractiseLLD.ParkingLot;

public class Slot {
    private final long id;
    public VehicleType vehicleType;
    public Vehicle vehicle;
    private boolean isAvailable = true;

    public Slot(Long id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public Long getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean supportsVehicleType(VehicleType vehicleType) {
        return vehicleType == this.vehicleType;
    }

    public void bookSlot(Vehicle vehicle) {
        isAvailable = false;
        this.vehicle = vehicle;
    }

    public void clearSlot() {
        isAvailable = true;
        this.vehicle = null;
    }
}
