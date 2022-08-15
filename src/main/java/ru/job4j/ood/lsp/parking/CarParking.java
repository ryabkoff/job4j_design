package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Парковка автомобилей
 */
public class CarParking implements Parking {
    private int seatsTruck;
    private int seatsPass;
    private Set<Car> truckStore;
    private Set<Car> passStore;
    private int occupiedPass;
    private int occupiedTruck;

    public CarParking(int seatsTruck, int seatsPass) {
        this.seatsTruck = seatsTruck;
        this.seatsPass = seatsPass;
        this.truckStore = new HashSet<>(seatsPass);
        this.passStore = new HashSet<>(seatsPass);
    }

    @Override
    public boolean put(Car car) {
        if (passStore.contains(car) || truckStore.contains(car)) {
            throw new IllegalArgumentException(
                    String.format("Автомобиль с номером %s уже припаркован", car.getNumber()));
        }
        boolean rsl = false;
        if (car.getSize() == PassengerCar.SIZE
                && occupiedPass < seatsPass) {
            rsl = passStore.add(car);
            occupiedPass++;
        } else if (car.getSize() > PassengerCar.SIZE
                && occupiedTruck < seatsTruck) {
                rsl = truckStore.add(car);
                occupiedTruck++;
        } else if (car.getSize() > PassengerCar.SIZE
                && seatsPass - occupiedPass >= car.getSize()) {
                rsl = passStore.add(car);
                occupiedPass += car.getSize();
        }
        return rsl;
    }

    @Override
    public boolean remove(Car car) {
        return passStore.remove(car) || truckStore.remove(car);
    }

    @Override
    public int getFreePassSeats() {
        return seatsPass - occupiedPass;
    }

    @Override
    public int getFreeTruckSeats() {
        return seatsTruck - occupiedTruck;
    }
}
