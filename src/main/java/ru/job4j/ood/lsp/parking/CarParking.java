package ru.job4j.ood.lsp.parking;

import java.util.*;

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
            return false;
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
    public boolean remove(String number) {
        boolean rsl = false;
        Car car = findByNumber(number);
        if (car != null) {
            if (passStore.contains(car)) {
                rsl = passStore.remove(car);
                occupiedPass -= car.getSize();
            } else if (truckStore.contains(car)) {
                rsl = truckStore.remove(car);
                occupiedTruck--;
            }
        }
        return rsl;
    }

    @Override
    public int getFreePassSeats() {
        return seatsPass - occupiedPass;
    }

    @Override
    public int getFreeTruckSeats() {
        return seatsTruck - occupiedTruck;
    }

    private Car findByNumber(String number) {
        Car rsl = null;
        for (Car car : passStore) {
            if (number.equals(car.getNumber())) {
                rsl = car;
                break;
            }
        }
        if (rsl == null) {
            for (Car car : truckStore) {
                if (number.equals(car.getNumber())) {
                    rsl = car;
                    break;
                }
            }
        }
        return rsl;
    }
}
