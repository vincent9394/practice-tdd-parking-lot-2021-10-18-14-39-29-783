package com.parkinglot.exception;

public class ParkingLotIsFullException extends RuntimeException{
    public ParkingLotIsFullException(){
        super("No available position");
    }
}
