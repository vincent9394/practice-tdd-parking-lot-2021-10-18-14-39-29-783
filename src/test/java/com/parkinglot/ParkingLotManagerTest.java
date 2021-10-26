package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerTest {
    @Test
    //#AC1
    void should_return_assigned_parking_boy_when_execute_add_parking_boy_given_a_parking_boy(){


//                (parkingLotManager.assignedParkingBoys.get(0));
        //given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(10));
        ParkingLotManager parkingLotManager = new ParkingLotManager(new ParkingLot(10));


        //when
        parkingLotManager.addParkingBoy(parkingBoy);
        List<StandardParkingBoy> assignedParkingBoys = parkingLotManager.assignedParkingBoys;

        //then
        assertNotNull(assignedParkingBoys);
    }
    @Test //AC1
    void should_return_assigned_parkingboy_to_parkCar_when_execute_assignParkTask_given_a_parkingboy_and_a_car_and_a_parkingLot(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        parkingLotManager.addParkingBoy(parkingBoy);




        //when
        Ticket ticket = parkingLotManager.assignParkTask(car, parkingBoy);

        //then
        assertNotNull(ticket);
    }

    @Test //AC1
    void should_return_assigned_parkingboy_to_fetchCar_when_execute_assignParkTask_given_a_parkingboy_and_a_car_and_a_parkingLot(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        parkingLotManager.addParkingBoy(parkingBoy);
        Ticket ticket = parkingLotManager.assignParkTask(car, parkingBoy);



        //when
        Car actualCar = parkingLotManager.assignFetchTask(ticket,parkingBoy);

        //then
        assertNotNull(ticket);
    }

    @Test//AC2
    void should_return_ticket_when_execute_assignParkTask_given_a_parking_manager_and_a_car(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        parkingLotManager.addParkingBoy(parkingLotManager);
        //when
        Ticket ticket = parkingLotManager.assignParkTask(car, parkingLotManager);

        //then
        assertNotNull(ticket);
    }

    @Test//AC2
    void should_return_car_when_execute_assignParkTask_given_a_parking_manager_and_a_ticket(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        parkingLotManager.addParkingBoy(parkingLotManager);

        Ticket ticket = parkingLotManager.assignParkTask(car, parkingLotManager);

        //when
        Car actualCar = parkingLotManager.assignFetchTask(ticket,parkingLotManager);
        //then
        assertNotNull(ticket);
    }

    @Test //AC3
    void should_error_msg_when_execute_assignParkTask_given_a_parkingboy_and_a_car_and_a_full_parkingLot(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
        parkingLotManager.addParkingBoy(parkingBoy);
        parkingLotManager.assignParkTask(car, parkingBoy);


        //when
        ParkingLotIsFullException parkingLotIsFullException = assertThrows(
                ParkingLotIsFullException.class, () -> parkingLotManager.assignParkTask(car,parkingBoy));


        //then
        assertEquals("No available position", parkingLotIsFullException.getMessage());
    }



}