package com.parkinglot;

import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);

    }

    @Override
    public Ticket parkCar(Car car) {
        ParkingLot availableParkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (availableParkingLot.getAvailability() < parkingLots.get(i).getAvailability()) {
                availableParkingLot = parkingLots.get(i);
            }
        }
        return availableParkingLot.parkCar(car);
    }


}
