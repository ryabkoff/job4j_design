package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/*
Легковой автомобиль
 */
public class PassengerCar implements Car {
    private final int size = 1;

    public PassengerCar() {
    }

    @Override
    public int getSize() {
        return size;
    }
}
