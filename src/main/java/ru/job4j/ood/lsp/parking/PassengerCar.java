package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/*
Легковой автомобиль
 */
public class PassengerCar implements Car {
    public static final int SIZE = 1;

    public PassengerCar() {
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}
