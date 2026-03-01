package PractiseLLD.ParkingLot;

public class Ticket {
    private final long id;
    private long entryTime;
    private double price;
    private Vehicle vehicle;
    private Slot slot;

    public Ticket(long id, Vehicle vehicle, Slot slot) {
        this.id = id;
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlots(Slot slot) {
        this.slot = slot;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
