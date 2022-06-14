package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index = -1;
    private int evenIndex = -1;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }
    @Override
    public boolean hasNext() {
        boolean rsl = false;
        for (int i = index + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = true;
                evenIndex = i;
                break;
            }
        }
        return rsl;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = evenIndex;
        return data[index];
    }
}
