package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<Ticket,Car> ticketCarMap = new HashMap<>();
    public int capacity;

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public Map<Ticket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public Ticket parkCar (Car car){
        if (ticketCarMap.containsValue(car) || car ==null){
            return null;
        }else if ((capacity -ticketCarMap.size())>0) {
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            ticketCarMap.get(ticket);
            return ticket;
        } else
        {
            throw new ParkingLotIsFullException();
        }
    }

    public Car fetchCar (Ticket ticket){
        if (ticketCarMap.containsKey(ticket)){
            Car car = ticketCarMap.get(ticket);
            ticketCarMap.remove(ticket);
            return car;
        } else {
            throw new UnrecognizedTicketException();
        }

    }

}



