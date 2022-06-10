package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        if (data[row].length > 0 && column < data[row].length) {
            rsl = true;
        } else {
            for (int i = row + 1; i < data.length; i++) {
                if (data[i].length > 0) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (data[row].length == 0) {
            row++;
        }
        int rsl = data[row][column];
        column++;
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return rsl;
    }
}