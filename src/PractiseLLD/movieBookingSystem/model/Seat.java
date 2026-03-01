package PractiseLLD.movieBookingSystem.model;

import PractiseLLD.movieBookingSystem.enums.SeatStatus;
import PractiseLLD.movieBookingSystem.enums.SeatType;

public class Seat {
    private final long id;
    private final int row;
    private final int col;
    private final SeatType seatType;
    private SeatStatus status;

    public Seat(long id, String title, int row, int col, SeatType seatType) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.seatType = seatType;
        this.status = SeatStatus.AVAILABLE;
    }

    public long getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SeatType getType() {
        return seatType;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatStatus getStatus() {
        return status;
    }
}
