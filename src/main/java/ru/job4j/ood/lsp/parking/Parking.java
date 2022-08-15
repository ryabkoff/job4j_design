package ru.job4j.ood.lsp.parking;

public interface Parking {
    boolean put(Car car);
    boolean remove(Car car);
    int getFreePassSeats();
    int getFreeTruckSeats();

}
