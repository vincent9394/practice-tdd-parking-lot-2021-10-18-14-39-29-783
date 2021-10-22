package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
        @Test
    void should_return_ticket_when_execute_parkCar_given_car_and_ParkingLot() {
//    given
            Car car = new Car();
            ParkingLot parkingLot = new ParkingLot(10);

//    when
            Ticket actualTicket =  parkingLot.parkCar(car);
//    then
            assertNotNull(actualTicket);
        }

        @Test
    void should_return_error_message_when_execute_parkCar_given_full_ParkingLot(){
            //given
            ParkingLot parkingLot = new ParkingLot(1);
            parkingLot.parkCar(new Car());
            Car car =new Car();
            //when
            ParkingLotIsFullException parkingLotIsFullException = assertThrows(ParkingLotIsFullException.class,()-> parkingLot.parkCar(car));
                    //MyException.class,
            //           () -> myObject.doThing(),
            //           "Expected doThing() to throw, but it didn't"


            //then
            assertEquals("No available position",parkingLotIsFullException.getMessage());

        }


}





