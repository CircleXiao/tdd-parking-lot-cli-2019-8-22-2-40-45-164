package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }

	public ParkingTicket park(Car car) {
		ParkingTicket parkingTicket = new ParkingTicket();
		cars.put(parkingTicket, car);
		return parkingTicket;
	}

	public Car fetch(ParkingTicket parkingTicket) {
		if (!cars.containsKey(parkingTicket)) {
			return null;
		}
		
		Car car = new Car();
		car = cars.get(parkingTicket);
		cars.remove(parkingTicket, car);
		return car;
	}
}
