package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Food> food = new ArrayList<>();
        food.add(new Fruit("apple",
                LocalDate.of(2022, 11, 12),
                LocalDate.of(2021, 9, 12),
                100, 5));
        food.add(new Fruit("apple",
                LocalDate.of(2023, 12, 12),
                LocalDate.of(2022, 9, 12),
                100, 5));
        food.add(new Fruit("beef",
                LocalDate.of(2022, 1, 12),
                LocalDate.of(2022, 11, 12),
                100, 5));
        food.add(new Fruit("milk",
                LocalDate.of(2022, 8, 10),
                LocalDate.of(2022, 8, 11),
                100, 5));
        Warehouse warehouse = new Warehouse();
        ControlQuality cq = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        food.forEach(cq::allocate);
        cq.getStores().forEach(s -> s.getAll().forEach(f -> System.out.println(s.getClass() + " " + f)));
    }
}
