package ru.job4j.ood.lsp.store;

import java.time.LocalDate;

public class Fruit extends Food {
    public Fruit(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
