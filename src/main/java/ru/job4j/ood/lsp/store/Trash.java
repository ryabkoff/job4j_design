package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private static final int EXP_PERCENT_FROM = 100;

    private List<Food> store = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = isFitByExpire(food);
        if (rsl) {
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
        return getPercent(food) >= EXP_PERCENT_FROM;
    }

    @Override
    public void clear() {
        store.clear();
    }
}
