package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import com.parkinglot.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    //story 5
    @Test
    //#1
    void should_return_ticket_when_execute_parkCar_given_car_and_parkingLot_and_smart_parking_boy() {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 =new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1,parkingLot2));

//    when
        Ticket actualTicket = parkingBoy.parkCar(car);
//    then
        assertTrue(parkingLot1.contains(car));
        assertFalse(parkingLot2.contains(car));
        assertNotNull(actualTicket);

    }

    @Test
        //#2
    void should_return_car_when_execute_fetchCar_given_ticket_and_a_standard_parking_boy() {
        //given
        Car car = new Car();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot(10));
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot(10));
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot(1));
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot(10));
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot(10));
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot(10));
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
    @Test
    //1
    void should_return_ticket_and_first_parkingLot_when_execute_parkCar_given_car_and_two_parkingLot_and_standard_parking_boy() {
        //given
        Car car = new Car();
//        List<ParkingLot> parkingLots
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(10), new ParkingLot(10)));


        //when
        Ticket actualTicket = parkingBoy.parkCar(car);

        //then
        assertNotNull(actualTicket);
        assertTrue(parkingBoy.getParkingLots().get(0).getTicketCarMap().containsKey(actualTicket));
    }

    @Test
        //2
    void should_return_ticket_and_park_second_parkingLot_when_execute_parkCar_given_car_and_two_parkingLot_first_is_full_and_standard_parking_boy() {

        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        parkingBoy.parkCar(car);


        //when
        Ticket actualTicket = parkingBoy.parkCar(car);

        //then
        assertNotNull(actualTicket);
        assertTrue(parkingBoy.getParkingLots().get(1).getTicketCarMap().containsKey(actualTicket));
    }

    @Test
//3
    void should_return_two_right_car_when_execute_fetch_car_given_two_parked_car_two_ticket_two_parkingLot_and_a_standard_parking_boy() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket ticket2 = parkingBoy.parkCar(car2);
        Ticket ticket1 = parkingBoy.parkCar(car1);

        //when
        Car actualCar1 = parkingBoy.fetchCar(ticket1);
        Car actualCar2 = parkingBoy.fetchCar(ticket2);
        //then
        assertEquals(car1, actualCar1);
        assertEquals(car2, actualCar2);
    }

    @Test
//4
    void should_return_error_msg_when_execute_fetch_car_given_an_unrecognized_ticket_two_parkingLots_and_a_standard_parking_boy() {
        //given
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));
        Car car = new Car();

        //when
        ParkingLotIsFullException parkingLotIsFullException = assertThrows(
                ParkingLotIsFullException.class, () -> parkingBoy.parkCar(car));


        //then
        assertEquals("No available position", parkingLotIsFullException.getMessage());

    }

    @Test
//5
    void should_return_error_msg_when_execute_parkCar_given_two_full_parkingLots_and_a_standard_parking_boy() {
        //given
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(10), new ParkingLot(10)));
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
//5
    void should_return_error_msg_when_execute_fetch_car_given_an_used_ticket_two_parkingLots_and_a_standard_parking_boy() {
        //given
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(10), new ParkingLot(10)));
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
}