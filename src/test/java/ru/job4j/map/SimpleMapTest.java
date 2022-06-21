package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutK1V100ThenGetK1() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 100);
        assertThat(map.get(1), is(100));
    }

    @Test
    public void whenPutK1V100ThenPutK1V200ThenGetK1() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 100);
        assertThat(map.get(1), is(100));
    }

    @Test
    public void whenPutK1V100ThenGet2() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        assertNull(map.get(2));
    }

    @Test
    public void whenPutK1V100ThenRemove1() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 100);
        assertTrue(map.remove(1));
    }

    @Test
    public void whenPutK1V100ThenRemove4() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 100);
        assertFalse(map.remove(4));
    }

    @Test
    public void whenNoElements() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void when2467Elements() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(2, 200);
        map.put(4, 400);
        map.put(6, 600);
        map.put(7, 700);
        Iterator<Integer> it = map.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModAfterStartIteration() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 100);
        Iterator<Integer> it = map.iterator();
        map.put(2, 200);
        it.next();
    }
}