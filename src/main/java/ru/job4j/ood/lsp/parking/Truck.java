package ru.job4j.ood.lsp.parking;

/*
Грузовой автомобиль
 */
public class Truck implements Car {

    public static final int TRUCK_SIZE = 2;
    private int size;

    public Truck(int size) {
        validation(size);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private static void validation(int size) {
        if (size < TRUCK_SIZE) {
            throw new IllegalArgumentException("Некорректный размер грузового автомобиля");
        }
    }
}
