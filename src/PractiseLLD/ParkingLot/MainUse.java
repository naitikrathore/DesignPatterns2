package PractiseLLD.ParkingLot;

import PractiseLLD.ParkingLot.pricing.HourlyPricingStrategy;
import PractiseLLD.ParkingLot.pricing.IPricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class MainUse {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Slot slot1 = new Slot(1L, VehicleType.CAR);
        Slot slot2 = new Slot(2L, VehicleType.BIKE);
        Slot slot3 = new Slot(3L, VehicleType.CAR);

        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        floor1.addSlot(slot1);
        floor1.addSlot(slot2);
        floor2.addSlot(slot3);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        Vehicle car = new Car("KA01AB1234");
        System.out.println("🚗 Vehicle Arrived: " + car.getNumber());

        Ticket ticket = parkingLot.parkVehicle(car);
        System.out.println("🎫 Ticket Generated at: " + ticket.getEntryTime());


        // 6️⃣ Exit Flow
        long exitTime = System.currentTimeMillis();
        long hours = ticket.getEntryTime()- exitTime;

        IPricingStrategy pricingStrategy = new HourlyPricingStrategy();
        double fee = pricingStrategy.calculatePrice(hours,ticket.getVehicle().getType());

        System.out.println("💰 Parking Fee: ₹" + fee);

        ticket.getSlot().clearSlot();

        Thread.sleep(3000);
    }
}
