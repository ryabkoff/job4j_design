package ru.job4j.ood.isp.example3;

/*
DBWriter производит только запись в базу данных, а реализовывать
приходится еще и метод read, в этом нарушение принципа ISP.
Решением является ращделение на отдельные интерфейсы.
 */
public class DBWriter implements DBServece {
    @Override
    public void read() {

    }

    @Override
    public void write() {

    }
}
