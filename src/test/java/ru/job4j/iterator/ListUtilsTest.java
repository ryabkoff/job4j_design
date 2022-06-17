package ru.job4j.iterator;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, num -> num == 2);
        assertThat(input, is(Arrays.asList(0, 1)));
    }

    @Test
    public void whenRemoveIfTrueForAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, num -> num >= 0);
        assertTrue(input.isEmpty());
    }

    @Test
    public void whenRemoveIfFalseForAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, num -> num < 0);
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void whenReplaceIfEvenWith9() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.replaceIf(input, num -> num % 2 == 0, 9);
        assertThat(input, is(Arrays.asList(9, 1, 9)));
    }

    @Test
    public void whenReplaceIfTrueForAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.replaceIf(input, num -> num >= 0, 9);
        assertThat(input, is(Arrays.asList(9, 9, 9)));
    }

    @Test
    public void whenReplaceIfFalseForAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.replaceIf(input, num -> num < 0, 9);
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(0, 2)));
        assertThat(input, is(Arrays.asList(1)));
    }

    @Test
    public void whenRemoveAllNothing() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(4, 5)));
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }
}