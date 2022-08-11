package ru.job4j.ood.lsp.parking;

/*
Грузовой автомобиль
 */
public class Truck implements Car {
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
