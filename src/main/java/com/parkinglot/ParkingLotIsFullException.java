package com.parkinglot;

public class ParkingLotIsFullException extends RuntimeException{
    public ParkingLotIsFullException(){
        super("No available position");
    }
}
