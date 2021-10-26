package com.parkinglot;

import com.parkinglot.exception.NoAssignedParkingBoy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends StandardParkingBoy {

    protected List<StandardParkingBoy> assignedParkingBoys = new ArrayList<>();

    public ParkingLotManager(List<ParkingLot> parkingLot) {
        super(parkingLot);
        this.assignedParkingBoys = new ArrayList<>();
    }

    public ParkingLotManager(ParkingLot parkingLot) {
        super(parkingLot);
    }


    public void addParkingBoy(StandardParkingBoy parkingBoy) {
        assignedParkingBoys.add(parkingBoy);
    }

    public Ticket assignParkTask(Car car, StandardParkingBoy parkingBoy) {
        if (assignedParkingBoys.contains(parkingBoy)) {
            return parkingBoy.parkCar(car);
        }
        throw new NoAssignedParkingBoy();
    }

    public Car assignFetchTask(Ticket ticket, StandardParkingBoy parkingBoy) {
        if (assignedParkingBoys.contains(parkingBoy)) {
            return parkingBoy.fetchCar(ticket);
        }
        throw new NoAssignedParkingBoy();
    }
}
