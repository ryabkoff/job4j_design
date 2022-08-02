package ru.job4j.ood.srp;

import java.util.ArrayList;

/*
1. Интерфейс Store - хранилище, метод analyze предоставляет дополнительный
функционал тем самым нарушает принцип srp, каждая абстракция должна отвечать
только за представления своего функционала. Analize необходимо выделить
в отдельную абстракцию
*/
public interface Store<T> {

    void put(T value);
    T get();
    void analyze();
}
