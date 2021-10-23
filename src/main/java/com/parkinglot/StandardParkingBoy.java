package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLot){
        this.parkingLots = parkingLot;
    }

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLots.add(parkingLot);
    }
    public List<ParkingLot> getParkingLot(){
        return parkingLots;
    }

}
