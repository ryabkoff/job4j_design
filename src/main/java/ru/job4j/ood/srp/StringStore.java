package ru.job4j.ood.srp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class StringStore implements Store<String> {

    private ArrayList<String> list;

    /*
    2. Нарушение принципа srp, метод put строук добавляет в list,
    и записывает в файл, работу с файлом необходимо выделить в отдельный функционал
    */
    @Override
    public void put(String value) {
        list.add(value);
        try {
            Files.writeString(Path.of("strings.txt"), value);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public void analyze() {

    }
    /*
    3. Нарушение принципа srp, метод выводит строку, что не относится к функциональности класса
     */
    public void printString(String value) {
        System.out.println(value);
    }
}
