package PractiseLLD.ParkingLot.pricing;

import PractiseLLD.ParkingLot.VehicleType;

public class HourlyPricingStrategy implements IPricingStrategy {
    @Override
    public double calculatePrice(Long duration, VehicleType type) {
        return switch (type){
            case BIKE ->  duration * 20;
            case CAR -> duration * 50;
            case TRUCK -> duration * 100;
        };
    }
}
