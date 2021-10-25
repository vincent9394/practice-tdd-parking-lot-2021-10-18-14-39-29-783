package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import com.parkinglot.exception.UnrecognizedTicketException;

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


    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket parkCar(Car car) {

        for (int i = 0; i < parkingLots.size(); i++) {
            if (!parkingLots.get(i).isFull())
                return parkingLots.get(i).parkCar(car);

        }
        throw new ParkingLotIsFullException();
    }

    public Car fetchCar(Ticket ticket) {

        for (int i = 0; i < parkingLots.size(); i++) {
            try {
                return parkingLots.get(i).fetchCar(ticket);
            } catch (RuntimeException ignored) {
            }
        }
        throw new UnrecognizedTicketException();
    }
}

