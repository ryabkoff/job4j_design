package ru.job4j.serialization.json;

public class OS {
    private String name;

    public OS(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OS{"
                + "phone='" + name + '\''
                + '}';
    }
}
