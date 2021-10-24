package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }


    public List<ParkingLot> getParkingLot() {
        return parkingLots;
    }

    public Ticket parkCar(Car car) {

        for (int i = 0; i < parkingLots.size(); i++) {

            return parkingLots.get(i).parkCar(car);

        }
        return null;
    }
}

