package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {
    //story 6
    @Test
    //#1
    void should_return_ticket_when_execute_parkCar_given_car_and_two_same_capacity_parkingLot_and_super_smart_parking_boy() {
        //given
        Car car = new Car();
        Car car1 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        parkingBoy.parkCar(car1);
//    when
        Ticket actualTicket = parkingBoy.parkCar(car);
//    then
        assertTrue(parkingLot2.contains(car));
        assertNotNull(actualTicket);

    }

    @Test
        //#2
    void should_return_ticket_when_execute_parkCar_given_car_and_two_parkingLot_second_has_more_position_rate_and_super_smart_parking_boy() {
        //given
        Car car = new Car();
        Car car1 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(100);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        parkingBoy.parkCar(car1);
//    when
        Ticket actualTicket = parkingBoy.parkCar(car);
//    then
        assertTrue(parkingLot2.contains(car));
        assertFalse(parkingLot1.contains(car));
        assertNotNull(actualTicket);

    }

    @Test
        //#3
    void should_return_two_car_when_execute_fetchCar_given_two_ticket_two_parkingLot_and_a_super_smart_parking_boy() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(8), new ParkingLot(10)));
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
//4
    void should_return_error_msg_when_execute_parkCar_given_an_unrecognized_ticket_and_a_super_smart_parking_boy() {
        //given
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(10), new ParkingLot(10)));
        Ticket ticket = new Ticket();

        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingBoy.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());

    }

    @Test
//5
    void should_return_error_msg_when_execute_fetch_car_given_an_used_ticket_two_parkingLots_and_a_super_smart_parking_boy() {
        //given
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(10), new ParkingLot(10)));
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);

        //when
        UnrecognizedTicketException unrecognizedTicketException = assertThrows(
                UnrecognizedTicketException.class, () -> parkingBoy.fetchCar(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedTicketException.getMessage());

    }

    @Test
//6
    void should_return_error_msg_when_execute_fetch_car_given_two_full_parkingLots_and_a_super_smart_parking_boy() {
        //given
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));
        Car car = new Car();

        //when
        ParkingLotIsFullException parkingLotIsFullException = assertThrows(
                ParkingLotIsFullException.class, () -> parkingBoy.parkCar(car));


        //then
        assertEquals("No available position", parkingLotIsFullException.getMessage());

    }


}