package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
    	ParkingTicket parkingTicket = new ParkingTicket();
    	parkingTicket = parkingLot.park(car);
    	return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
        Car car = new Car();
        car = parkingLot.fetch(ticket);
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
