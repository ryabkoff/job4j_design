package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
public class CarParkingTest {

    @Test
    public void whenParkingSize2Pass1TruckPut2Pass1Truck() {
        Parking parking = new CarParking(1, 2);
        assertTrue(parking.put(new PassengerCar("123")));
        assertTrue(parking.put(new PassengerCar("456")));
        assertTrue(parking.put(new Truck("789", 2)));
    }

    @Test
    public void whenParkingSize2Pass1TruckPut2TrucSize2k() {
        Parking parking = new CarParking(1, 2);
        assertTrue(parking.put(new Truck("789", 2)));
        assertTrue(parking.put(new Truck("987", 2)));
    }

    @Test
    public void whenParkingSize1Pass1TruckPut2Pass() {
        Parking parking = new CarParking(1, 0);
        assertFalse(parking.put(new PassengerCar("123")));
    }

    @Test
    public void whenParkingSize1Pass1Truck1TruckPut2Pass() {
        Parking parking = new CarParking(1, 1);
        assertTrue(parking.put(new PassengerCar("123")));
        assertFalse(parking.put(new PassengerCar("456")));
    }

    @Test
    public void whenParkingSize1TruckPut2Truck() {
        Parking parking = new CarParking(1, 0);
        assertTrue(parking.put(new Truck("987", 2)));
        assertFalse(parking.put(new Truck("765", 2)));
    }

    @Test
    public void whenParkingDuplicateCar() {
        Parking parking = new CarParking(1, 0);
        assertTrue(parking.put(new Truck("987", 2)));
        assertThatThrownBy(() -> parking.put(new Truck("987", 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("уже припаркован");
    }

    @Test
    public void whenRemovePassCar() {
        Parking parking = new CarParking(1, 1);
        Car car = new PassengerCar("123");
        parking.put(car);
        assertTrue(parking.remove(car));
        assertThat(parking.getFreePassSeats()).isEqualTo(0);
        assertThat(parking.getFreeTruckSeats()).isEqualTo(1);
    }

    @Test
    public void whenRemoveTruckCar() {
        Parking parking = new CarParking(1, 1);
        Car car = new Truck("123", 2);
        parking.put(car);
        assertTrue(parking.remove(car));
        assertThat(parking.getFreePassSeats()).isEqualTo(1);
        assertThat(parking.getFreeTruckSeats()).isEqualTo(0);
    }

    @Test
    public void whenRemoveTruckFromPassParking() {
        Parking parking = new CarParking(0, 2);
        Car car = new Truck("123", 2);
        parking.put(car);
        assertTrue(parking.remove(car));
        assertThat(parking.getFreePassSeats()).isEqualTo(0);
        assertThat(parking.getFreeTruckSeats()).isEqualTo(0);
    }
}