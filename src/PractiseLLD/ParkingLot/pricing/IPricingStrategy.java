package PractiseLLD.ParkingLot.pricing;

import PractiseLLD.ParkingLot.VehicleType;

public interface IPricingStrategy {
    double calculatePrice(Long duration,VehicleType type);
}
