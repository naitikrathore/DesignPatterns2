package PractiseLLD.ParkingLot.pricing;

import PractiseLLD.ParkingLot.VehicleType;

public class MinutePricingStrategy implements IPricingStrategy {
    @Override
    public double calculatePrice(Long duration, VehicleType type) {
        return switch (type){
            case BIKE -> duration * 10;
            case CAR -> duration * 30;
            case TRUCK -> duration * 50;
        };
    }
}
