package com.parkinglot.exception;

public class NoAssignedParkingBoy extends RuntimeException {
    public NoAssignedParkingBoy() {
        super("No assigned parking boy");
    }
}
