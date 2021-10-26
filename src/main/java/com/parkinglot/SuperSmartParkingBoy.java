package com.parkinglot;

import java.util.List;

public class SuperSmartParkingBoy extends StandardParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public Ticket parkCar(Car car) {
        ParkingLot availableParkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (availableParkingLot.getAvailabilityRate() < parkingLots.get(i).getAvailabilityRate()) {
                availableParkingLot = parkingLots.get(i);
            }
        }
        return availableParkingLot.parkCar(car);
    }
}
