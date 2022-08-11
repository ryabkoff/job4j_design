package ru.job4j.ood.isp.example2;

/*
ElctroCar не нуждается в заправке топливом, поэтому метод refuel
не нужен в данном классе, в этом нарушение принципа ISP.
Решением является ращделение на отдельные интерфейсы.
 */

public class ElctroCar implements Car {
    @Override
    public void refuel() {

    }

    @Override
    public void charge() {

    }
}
