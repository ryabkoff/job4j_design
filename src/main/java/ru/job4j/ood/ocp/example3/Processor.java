package ru.job4j.ood.ocp.example3;

import java.util.List;
import java.util.stream.Collectors;

public class Processor {
    /*
    3. Имеем иерархию классов Figure -> Circle, метод area вычисляет площадь
    класс Processor обрабатывает фигуры. В методе filterByArea ошибка,
    в параметрах и в возвращаемом значении в качестве типа использованы не абстракции
     */
    public static List<Circle> filterByArea(List<Circle> list, double area) {
        return list.stream()
                .filter(x -> x.area() > area)
                .collect(Collectors.toList());
    }
}
