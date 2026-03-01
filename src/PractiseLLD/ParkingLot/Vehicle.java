package PractiseLLD.ParkingLot;

public abstract class Vehicle {
    public String vehicleNumber;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    abstract public VehicleType getType();

    public String getNumber() {
        return vehicleNumber;
    }
}
