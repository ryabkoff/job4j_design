package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlQualityTest {

    @Test
    public void whenFoodAddToShop() {
        Store shop = new Shop();
        Food food = new Fruit("apple",
                LocalDate.now().plusMonths(5),
                LocalDate.now().minusMonths(5),
                100, 5);
        ControlQuality cq = new ControlQuality(List.of(shop));
        cq.allocate(food);
        assertThat(shop.getAll()).isEqualTo(List.of(food));
    }

    @Test
    public void whenFoodAddToShopAndApplyDiscount() {
        Store shop = new Shop();
        Food food = new Fruit("apple",
                LocalDate.now().plusMonths(2),
                LocalDate.now().minusMonths(8),
                100, 5);
        ControlQuality cq = new ControlQuality(List.of(shop));
        cq.allocate(food);
        assertThat(shop.getAll()).isEqualTo(List.of(food));
        assertThat(shop.get(0).getPrice()).isEqualTo(95);
    }

    @Test
    public void whenFoodAddToWareHouse() {
        Store wareHouse = new Warehouse();
        Food food = new Fruit("apple",
                LocalDate.now().plusMonths(9),
                LocalDate.now().minusMonths(1),
                100, 5);
        ControlQuality cq = new ControlQuality(List.of(wareHouse));
        cq.allocate(food);
        assertThat(wareHouse.getAll()).isEqualTo(List.of(food));
    }

    @Test
    public void whenFoodAddToTrash() {
        Store trash = new Trash();
        Food food = new Fruit("apple",
                LocalDate.now().plusMonths(0),
                LocalDate.now().minusMonths(10),
                100, 5);
        ControlQuality cq = new ControlQuality(List.of(trash));
        cq.allocate(food);
        assertThat(trash.getAll()).isEqualTo(List.of(food));
    }

    @Test
    public void whenSortFoodToStore() {
        Store wareHouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        Food fruit = new Fruit("apple",
                LocalDate.now().plusMonths(5),
                LocalDate.now().minusMonths(5),
                100, 5);
        Food meat = new Fruit("meat",
                LocalDate.now().plusMonths(9),
                LocalDate.now().minusMonths(1),
                100, 5);
        Food milk = new Fruit("milk",
                LocalDate.now().plusMonths(0),
                LocalDate.now().minusMonths(10),
                100, 5);
        List<Food> food = List.of(fruit, meat, milk);
        ControlQuality cq = new ControlQuality(List.of(wareHouse, shop, trash));
        food.forEach(cq::allocate);
        assertThat(shop.getAll()).isEqualTo(List.of(fruit));
        assertThat(wareHouse.getAll()).isEqualTo(List.of(meat));
        assertThat(trash.getAll()).isEqualTo(List.of(milk));
    }
}