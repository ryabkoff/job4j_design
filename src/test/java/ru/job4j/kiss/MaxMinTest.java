package ru.job4j.kiss;

import org.junit.Test;
import ru.job4j.collection.SimpleStack;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void testMax() {
        MaxMin maxMin = new MaxMin();
        int expected = 99;
        int result = maxMin.max(List.of(1, 2, 3, 4, 99, 0),
                Comparator.comparingInt(l -> l));
        assertThat(result, is(expected));
    }

    @Test
    public void testMin() {
        MaxMin maxMin = new MaxMin();
        int expected = 0;
        int result = maxMin.min(List.of(1, 2, 3, 4, 99, 0),
                Comparator.comparingInt(l -> l));
        assertThat(result, is(expected));
    }
}