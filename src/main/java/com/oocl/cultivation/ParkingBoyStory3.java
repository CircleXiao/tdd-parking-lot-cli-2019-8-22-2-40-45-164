package com.oocl.cultivation;

public class ParkingBoyStory3 extends ParkingBoy{
	private ParkingLot parkingLotOne;
	private ParkingLot parkingLotTwo;
    private String lastErrorMessage;

	public ParkingBoyStory3(ParkingLot parkingLotOne, ParkingLot parkingLotTwo) {
		super(parkingLotOne);
		this.parkingLotTwo = parkingLotTwo;
	}
	
	public ParkingTicket park(Car car) {
		ParkingTicket parkingTicket = new ParkingTicket();
		
    	if (this.parkingLotOne.getAvailableParkingPosition() < 1) {
			lastErrorMessage = "The parking lot one is full.";
			
			if (this.parkingLotTwo.getAvailableParkingPosition() < 1) {
				lastErrorMessage = "The parking lot one and two are both full.";
				return null;
			} else {
				parkingTicket = parkingLotTwo.park(car);
			}
    		
		}
    	
    	parkingTicket = parkingLotOne.park(car);
    	
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
        car = parkingLotOne.fetch(ticket);     
        if (car == null) {
			lastErrorMessage = "This car is not parked in the first parking lot.";
			car = parkingLotTwo.fetch(ticket);
			if (car == null) {
				lastErrorMessage = "This car is not parked in the second parking lot.";
			}
		}
        return car;
    }
    
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

}
