package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Store {
    boolean add(Food food);
    Food get(int index);
    List<Food> getAll();
    boolean isFitByExpire(Food food);

    default double getPercent(Food food) {
        double total = food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS);
        double current = food.getCreateDate().until(LocalDate.now(), ChronoUnit.DAYS);
        return (current / total) * 100;
    }

}
