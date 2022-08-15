package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/*
Грузовой автомобиль
 */
public class Truck implements Car {

    private int size;
    private String number;

    public Truck(String number, int size) {
        validation(size);
        this.size = size;
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private static void validation(int size) {
        if (size == PassengerCar.SIZE) {
            throw new IllegalArgumentException("Некорректный размер грузового автомобиля");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return size == truck.size && Objects.equals(number, truck.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, number);
    }
}
