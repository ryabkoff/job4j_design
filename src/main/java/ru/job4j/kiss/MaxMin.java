package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    private <T> T comp(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.isEmpty() ? null : value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (predicate.test(comparator.compare(value.get(i), rsl))) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comp(value, comparator, c -> c > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comp(value, comparator, c -> c < 0);
    }

    public static void main(String[] args) {
        List<String> list = List.of("asdq", "qsqqzxc", "123");
        MaxMin mm = new MaxMin();
        System.out.println(mm.max(list, Comparator.comparingInt(String::length)));
        System.out.println(mm.min(list, Comparator.comparingInt(String::length)));
    }
}