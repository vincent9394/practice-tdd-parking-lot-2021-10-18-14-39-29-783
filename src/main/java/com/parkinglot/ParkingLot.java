package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<Ticket,Car> ticketCarMap = new HashMap<>();
    public int capacity;
    public int availableCapacity;

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public Ticket parkCar (Car car){
        if ((capacity -ticketCarMap.size())>0) {
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            ticketCarMap.get(ticket);
            return ticket;
        } else{
            throw new ParkingLotIsFullException();
        }



    }

}
