package ru.job4j.ood.dip;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String text;

    public void print() {
    /*
    2. Здесь нарушение принципа DIP, печать книги зависит от консольного вывода.
    Необходимо использовать абстракцию, чтобы использвовать вывод в другие приемники
    файл, графический интерфейс и т.д.
     */
        System.out.println(text);
    }
}
