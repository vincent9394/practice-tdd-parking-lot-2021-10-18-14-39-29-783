package com.parkinglot;

import com.parkinglot.exception.ParkingLotIsFullException;
import com.parkinglot.exception.UnrecognizedTicketException;

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

        if (contains(car) || car == null || isFull()) {
            throw new ParkingLotIsFullException();
        } else
        {
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            return ticket;
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

    public boolean contains(Car car) {
        return ticketCarMap.containsValue(car);
    }

    public boolean isFull() {
        return ticketCarMap.size() >= capacity;
    }

    public int getAvailability() {
        return capacity - ticketCarMap.size();
    }

    public double getAvailabilityRate() {
        return (double) getAvailability() / capacity;
    }

}



