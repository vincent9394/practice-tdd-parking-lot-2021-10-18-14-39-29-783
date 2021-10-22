package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
        @Test
    void should_return_ticket_when_execute_parkCar_given_car_and_ParkingLot() {
//    given
            Car car = new Car();
            ParkingLot parkinglot = new ParkingLot();

//    when
            Ticket actualTicket =  parkinglot.parkCar(car);
//    then
            assertNotNull(actualTicket);
        }
}