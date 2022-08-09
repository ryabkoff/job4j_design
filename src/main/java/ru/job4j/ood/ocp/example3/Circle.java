package ru.job4j.ood.ocp.example3;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * Math.PI * radius;
    }
}
