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
        for (int i = row; i < data.length; i++) {
            int start = i == row ? column : 0;
            for (int j = start; j < data[i].length; j++) {
                return true;
            }
        }
        return false;
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