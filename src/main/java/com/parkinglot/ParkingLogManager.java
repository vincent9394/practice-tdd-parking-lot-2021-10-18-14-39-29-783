package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLogManager extends StandardParkingBoy {

    protected List<StandardParkingBoy> assignedParkingBoys = new ArrayList<>();

    public ParkingLogManager(List<ParkingLot> parkingLot) {
        super(parkingLot);
        this.assignedParkingBoys = new ArrayList<>();
    }

    public ParkingLogManager(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public void addParkingBoy(StandardParkingBoy boy) {
        assignedParkingBoys.add(boy);
    }

    public Ticket assignParkTask(Car car, StandardParkingBoy boy) {
        if (assignedParkingBoys.contains(boy)) {
            return boy.parkCar(car);
        }
        throw new RuntimeException("The boy is not in the management list.");
    }

    public Car assignFetchTask(Ticket ticket, StandardParkingBoy boy) {
        if (assignedParkingBoys.contains(boy)) {
            return boy.fetchCar(ticket);
        }
        throw new RuntimeException("The boy is not in the management list.");
    }
}
