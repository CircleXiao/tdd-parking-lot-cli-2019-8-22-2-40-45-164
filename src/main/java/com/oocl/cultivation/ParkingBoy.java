package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

	public ParkingTicket park(Car car) {
    	if (this.parkingLot.getAvailableParkingPosition() < 1) {
			lastErrorMessage = "The parking lot is full.";
    		return null;
		}
    	
    	ParkingTicket parkingTicket = new ParkingTicket();
    	parkingTicket = parkingLot.park(car);
    	
    	if (parkingTicket != null) {
			lastErrorMessage = null;
		}
    	return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
    	if (ticket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
        Car car = new Car();
        car = parkingLot.fetch(ticket);     
        if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
