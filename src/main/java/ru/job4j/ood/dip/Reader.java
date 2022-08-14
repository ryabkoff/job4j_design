package ru.job4j.ood.dip;

import java.util.ArrayList;

public class Reader {

    /*
    3. Здесь нарушение принципа DIP, в вхдных параметрах использован
    ArrayList - конкретный класс, а не абстракция.
     */
    public void getBook(ArrayList<Book> books) {

    }
}
