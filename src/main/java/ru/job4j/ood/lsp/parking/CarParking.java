package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Парковка автомобилей
 */
public class CarParking implements Parking {
    private int placesForTrucks;
    private int placesForPassCar;
    private List<Car> truckStore;
    private List<Car> passStore;

    public CarParking(int placesForTrucks, int placesForPassCar) {
        this.placesForTrucks = placesForTrucks;
        this.placesForPassCar = placesForPassCar;
        this.truckStore = new ArrayList<>(placesForTrucks);
        this.passStore = new ArrayList<>(placesForPassCar);
    }

    @Override
    public void put(Car car) {

    }

    @Override
    public void remove(Car car) {

    }
}
