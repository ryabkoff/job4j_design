package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class SimpleMenuPrinter implements MenuPrinter {
    public static final String SPACE = " ";
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> System.out.println(SPACE.repeat(i.getNumber().length() - 2)
                + i.getNumber()
                + i.getName()));
    }
}
