package PractiseLLD.airlineManagementSystem.model;

import java.time.LocalDateTime;

public class BoardingPass {
    private final String boardingPassId;
    private final String bookingId;
    private final String passengerName;
    private final String flightNumber;
    private final String seatNumber;
    private final String gate;
    private final LocalDateTime boardingTime;
    private final String qrCode;

    public BoardingPass(String boardingPassId, String bookingId, String passengerName,
                        String flightNumber, String seatNumber, String gate,
                        LocalDateTime boardingTime, String qrCode) {
        this.boardingPassId = boardingPassId;
        this.bookingId      = bookingId;
        this.passengerName  = passengerName;
        this.flightNumber   = flightNumber;
        this.seatNumber     = seatNumber;
        this.gate           = gate;
        this.boardingTime   = boardingTime;
        this.qrCode         = qrCode;
    }

    public String getBoardingPassId() { return boardingPassId; }
    public String getBookingId()      { return bookingId; }
    public String getPassengerName()  { return passengerName; }
    public String getFlightNumber()   { return flightNumber; }
    public String getSeatNumber()     { return seatNumber; }
    public String getGate()           { return gate; }
    public LocalDateTime getBoardingTime() { return boardingTime; }
    public String getQrCode()         { return qrCode; }
}
