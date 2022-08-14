package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/*
Парковка автомобилей
 */
public class CarParking implements Parking {
    private int seatsTruck;
    private int seatsPass;
    private List<Car> truckStore;
    private List<Car> passStore;
    private int occupiedPass;
    private int occupiedTruck;

    public CarParking(int seatsTruck, int seatsPass) {
        this.seatsTruck = seatsTruck;
        this.seatsPass = seatsPass;
        this.truckStore = new ArrayList<>(seatsPass);
        this.passStore = new ArrayList<>(seatsPass);
    }

    @Override
    public boolean put(Car car) {
        boolean rsl = false;
        if (car.getSize() == PassengerCar.SIZE) {
            if (occupiedPass < seatsPass) {
                rsl = passStore.add(car);
                occupiedPass++;
            }
        } else {
            if (occupiedTruck < seatsTruck) {
                rsl = truckStore.add(car);
                occupiedTruck++;
            } else if (seatsPass - occupiedPass >= car.getSize()) {
                rsl = passStore.add(car);
                occupiedPass += car.getSize();
            }
        }
        return rsl;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }
}
