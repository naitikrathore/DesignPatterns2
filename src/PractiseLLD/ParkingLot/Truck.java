package PractiseLLD.ParkingLot;

public class Truck extends Vehicle{
    public Truck(String number){
        super(number);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
