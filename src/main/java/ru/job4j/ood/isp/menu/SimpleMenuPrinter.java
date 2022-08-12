package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class SimpleMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> System.out.println(" ".repeat(i.getNumber().length() - 2)
                + i.getNumber()
                + i.getName()));
    }
}
