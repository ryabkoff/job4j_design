package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void allocate(Food food) {
        for (Store store : stores) {
            if (store.add(food)) {
                break;
            }
        }
    }

    public List<Store> getStores() {
        return List.copyOf(stores);
    }

    public void resort() {
        List<Food> listFood = new ArrayList<>();
        for (Store store : stores) {
            listFood.addAll(store.getAll());
            store.clear();
        }
        for (Food food : listFood) {
            allocate(food);
        }
    }
}
