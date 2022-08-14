package ru.job4j.ood.dip;

import java.util.ArrayList;

public class Library {
    /*
    1. Здесь нарушение принципа DIP, в качестве типа использован
    ArrayList - конкретный класс, а не абстракция.
     */
    ArrayList<Book> books;
}
