package PractiseLLD.airlineManagementSystem.factory;

import PractiseLLD.airlineManagementSystem.enums.SeatType;
import PractiseLLD.airlineManagementSystem.model.Aircraft;
import PractiseLLD.airlineManagementSystem.model.Seat;


public class AircraftFactory {
    private static long id;

    private AircraftFactory() {}

    public static Aircraft createBoeing777() {
        Aircraft ac = new Aircraft(++id,"Boeing777");
        populateSeats(ac, 10, 20,  40000, 15000);
        return ac;
    }

    public static Aircraft createAirbusA320() {
        Aircraft ac = new Aircraft(++id, "Airbus A320");
        populateSeats(ac, 8, 12,  28000, 11000);
        return ac;
    }

    private static void populateSeats(Aircraft ac, int bizCount, int ecoCount, double bizPrice, double ecoPrice) {
        int row = 1;

        for (int i = 0; i < bizCount; i++) {
            char col = (char) ('A' + i % 4);
            ac.addSeat(new Seat(id+100+i, row + "" + col, SeatType.Business, bizPrice));
            if ((i + 1) % 4 == 0) row++;
        }


        for (int i = 0; i < ecoCount; i++) {
            char col = (char) ('A' + i % 6);
            ac.addSeat(new Seat(id+200+i, row + "" + col, SeatType.Economy, ecoPrice));
            if ((i + 1) % 6 == 0) row++;
        }
    }
}
