package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CarParkingTest {

    @Test
    public void whenParkingSize2Pass1TruckPut2Pass1Truck() {
        Parking parking = new CarParking(1, 2);
        assertTrue(parking.put(new PassengerCar()));
        assertTrue(parking.put(new PassengerCar()));
        assertTrue(parking.put(new Truck(2)));
    }

    @Test
    public void whenParkingSize2Pass1TruckPut1TrucSize1kAnd1TruckSize2() {
        Parking parking = new CarParking(1, 2);
        assertTrue(parking.put(new Truck(1)));
        assertTrue(parking.put(new Truck(2)));
    }

    @Test
    public void whenParkingSize1Pass1TruckPut2Pass() {
        Parking parking = new CarParking(1, 0);
        assertTrue(parking.put(new PassengerCar()));
        assertFalse(parking.put(new PassengerCar()));
    }

    @Test
    public void whenParkingSize1Pass1Truck1TruckPut2Pass() {
        Parking parking = new CarParking(1, 1);
        assertTrue(parking.put(new PassengerCar()));
        assertFalse(parking.put(new PassengerCar()));
    }

    @Test
    public void whenParkingSize1TruckPut2Truck() {
        Parking parking = new CarParking(0, 1);
        assertTrue(parking.put(new Truck(1)));
        assertFalse(parking.put(new Truck(1)));
    }
}