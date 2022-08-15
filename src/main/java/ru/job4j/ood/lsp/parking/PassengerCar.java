package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/*
Легковой автомобиль
 */
public class PassengerCar implements Car {
    public static final int SIZE = 1;
    private String number;

    public PassengerCar(String number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
