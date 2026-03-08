package PractiseLLD.airlineManagementSystem.model;

import PractiseLLD.airlineManagementSystem.enums.SeatStatus;
import PractiseLLD.airlineManagementSystem.enums.SeatType;

public class Seat {
    private final long id;
    private final String seatNumber;
    private SeatStatus status;
    private final SeatType type;
    private final double basePrice;

    public Seat(long seatId, String seatNumber, SeatType type, double basePrice) {
        this.id = seatId;
        this.seatNumber = seatNumber;
        this.type = type;
        this.basePrice = basePrice;
        this.status = SeatStatus.Available;
    }

    public long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public SeatType getType() {
        return type;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
