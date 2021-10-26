package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    //Story 1
    @Test
    //#1
    void should_return_ticket_when_execute_parkCar_given_car_and_parkingLot() {
//    given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);

//    when
        Ticket actualTicket = parkingLot.parkCar(car);
//    then
        assertNotNull(actualTicket);
    }

//    @Test
        //#2
//    void should_return_null_when_execute_parkCar_given_null_car() {
//        //given
//        Car car = null;
//        ParkingLot parkingLot = new ParkingLot(1);
//
//        //when
//        Ticket actualTicket = parkingLot.parkCar(null);
//
//        //then
//        assertNull(actualTicket);
//    }

//    @Test
//        //#3
//    void should_return_null_when_execute_partCar_when_given_parked_car() {
//
//        //given
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car car = new Car();
//        parkingLot.parkCar(car);
//
//        //when
//        Ticket ticket = parkingLot.parkCar(car);
//
//        //then
//        assertNull(ticket);
//    }
//    @Test //#4
//    void should_return_null_when_execute_parkCar_when_givem_full_parkingLot(){
//        //given
//        ParkingLot parkingLot = new ParkingLot(1);
//        parkingLot.parkCar(new Car());
//        Car car = new Car();
//
//        //when
//        Ticket ticket = parkingLot.parkCar(car);
//
//        //then
//        assertNull(ticket);
//    }

    @Test
        //#5
    void should_return_car_when_execute_fetch_car_given_Ticket() {
        //given

        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parkCar(new Car());

        //when
        Car actualCar = parkingLot.fetchCar(ticket);

        //then
        assertNotNull(actualCar);
    }

//    @Test //#6
//    void should_return_null_when_execute_fetch_car_given_null_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot(10);
//        Ticket ticket = null;
//
//        //when
//        Car actualCar = parkingLot.fetchCar(ticket);
//
//        //then
//        assertNull(actualCar);
//    }

//    @Test //#7
//    void should_return_null_when_execute_fetch_car_given_used_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot(10);
//        Ticket ticket = parkingLot.parkCar(new Car());
//        parkingLot.fetchCar(ticket);
//
//        //when
//        Car actualCar = parkingLot.fetchCar(ticket);
//
//        //then
//        assertNull(actualCar);
//    }


    //    @Test //#8
//    void should_return_null_when_execute_fetch_car_given_wrong_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot(10);
//        Car car1 = new Car();
//        Car car2 = new Car();
//        parkingLot.parkCar(car1);
//        Ticket ticket2 = parkingLot.parkCar(car2);
//
//        //when
//        Car actualCar1 = parkingLot.fetchCar(ticket2);
//
//        //then
//        assertNotEquals(car1, actualCar1);
//    }
//------------------------------------------------------------------------------------------
    //story 2
    @Test
    //# 1
    void should_return_error_message_when_execute_fetchCar_given_full_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkCar(new Car());
        Car car = new Car();
        //when
        ParkingLotIsFullException parkingLotIsFullException = assertThrows(
                ParkingLotIsFullException.class, () -> parkingLot.parkCar(car));
        //MyException.class,
        //           () -> myObject.doThing(),
        //           "Expected doThing() to throw, but it didn't"


        //then
        assertEquals("No available position", parkingLotIsFullException.getMessage());

    }

    @Test
        //#2
    void should_return_error_message_when_execute_fetchCar_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parkCar(new Car());
        parkingLot.fetchCar(ticket);

        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingLot.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());
    }

    @Test
        //#3
    void should_return_error_message_when_execute_fetchCar_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = new Ticket();


        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingLot.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());

    }

    @Test
        //#4
    void should_return_error_message_when_execute_fetch_car_given_null_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = null;


        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingLot.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());

    }


}









