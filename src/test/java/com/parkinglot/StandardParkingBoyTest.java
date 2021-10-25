package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardParkingBoyTest {
    //------------------------------------------------------------------------------------------
    //story 3
    @Test
    //#1
    void should_return_ticket_when_execute_parkCar_given_car_and_parkingLot_and_standard_parking_boy() {
        //given
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));

//    when
        Ticket actualTicket = parkingBoy.parkCar(car);
//    then
        assertNotNull(actualTicket);
    }

    @Test
        //#2
    void should_return_car_when_execute_fetchCar_given_ticket_and_a_standard_parking_boy() {
        //given
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));
        Ticket ticket = parkingBoy.parkCar(car);

        //when
        Car actualCar = parkingBoy.fetchCar(ticket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
        //#3
    void should_return_two_car_when_execute_fetchCar_given_two_ticket_and_a_standard_parking_boy() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);

        //when
        Car actualCar1 = parkingBoy.fetchCar(ticket1);
        Car actualCar2 = parkingBoy.fetchCar(ticket2);

        //then
        assertEquals(car1, actualCar1);
        assertEquals(car2, actualCar2);
    }

    @Test
        //# 4
    void should_return_error_message_when_execute_parkCar_given_full_parkingLot_and_a_standard_parking_boy() {
        //given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(1));
        parkingBoy.parkCar(new Car());
        Car car = new Car();
        //when
        ParkingLotIsFullException parkingLotIsFullException = assertThrows(
                ParkingLotIsFullException.class, () -> parkingBoy.parkCar(car));

        //then
        assertEquals("No available position", parkingLotIsFullException.getMessage());

    }

    @Test
        //#5
    void should_return_error_message_when_execute_fetchCar_given_used_ticket_and_standard_parking_boy() {
        //given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));
        Ticket ticket = parkingBoy.parkCar(new Car());
        parkingBoy.fetchCar(ticket);

        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingBoy.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());
    }

    @Test
        //#6
    void should_return_error_message_when_execute_parkCar_given_wrong_ticket_and_standard_parking_boy() {
        //given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));
        Ticket ticket = new Ticket();


        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingBoy.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());

    }

    @Test
        //#7
    void should_return_error_message_when_execute_parkCar_given_null_ticket_and_standard_parking_boy() {
        //given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));
        Ticket ticket = null;


        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingBoy.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());

    }


    //------------------------------------------------------------------------------------------
    //story 4
    @Test //1
    void should_return_ticket_and_first_parkingLot_when_execute_parkCar_given_car_and_two_parkingLot_and_standard_parking_boy() {
        //given
        Car car = new Car();
//        List<ParkingLot> parkingLots
        StandardParkingBoy parkingBoy = new StandardParkingBoy(Arrays.asList(new ParkingLot(10), new ParkingLot(10)));


        //when
        Ticket actualTicket = parkingBoy.parkCar(car);

        //then
        assertNotNull(actualTicket);
        assertTrue(parkingBoy.getParkingLots().get(0).getTicketCarMap().containsKey(actualTicket));
    }

    @Test //2
    void should_return_ticket_and_park_second_parkingLot_when_execute_parkCar_given_car_and_two_parkingLot_first_is_full_and_standard_parking_boy(){

        //given
        Car car = new Car();
        ParkingLot parkingLot1 =new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(Arrays.asList(parkingLot1,parkingLot2));
        parkingBoy.parkCar(car);


        //when
        Ticket actualTicket = parkingBoy.parkCar(car);

        //then
        assertNotNull(actualTicket);
        assertTrue(parkingBoy.getParkingLots().get(1).getTicketCarMap().containsKey(actualTicket));
    }
}
