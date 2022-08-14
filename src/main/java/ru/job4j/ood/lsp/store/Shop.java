package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private static final int EXP_PERCENT_FROM = 25;
    private static final int EXP_PERCENT_TO = 100;
    private static final int DISCOUNT_PERCENT = 75;

    private List<Food> store = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = isFitByExpire(food);
        if (rsl) {
            applyDiscount(food);
            store.add(food);
        }
        return rsl;
    }

    @Override
    public Food get(int index) {
        return store.get(index);
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(store);
    }

    @Override
    public boolean isFitByExpire(Food food) {
        return getPercent(food) >= EXP_PERCENT_FROM
                && getPercent(food) < EXP_PERCENT_TO;
    }

    @Override
    public void clear() {
        store.clear();
    }

    private void applyDiscount(Food food) {
        if (getPercent(food) >= DISCOUNT_PERCENT) {
            food.setPrice(food.getPrice()
                    * (100 - food.getDiscount()) / 100);
        }
    }
}
