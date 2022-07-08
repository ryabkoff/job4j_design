package ru.job4j.serialization.json;

import java.util.Arrays;

public class Computer {
    private boolean isNotebook;
    private int ram;
    private String cpu;
    private String[] devices;
    private OS os;

    public Computer(boolean isNotebook, int ram, String cpu, String[] devices, OS os) {
        this.isNotebook = isNotebook;
        this.ram = ram;
        this.cpu = cpu;
        this.devices = devices;
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer{"
                + "isNotebook=" + isNotebook
                + ", ram=" + ram
                + ", cpu=" + cpu
                + ", devices=" + Arrays.toString(devices)
                + ", os" + os
                + '}';
    }

    public boolean isNotebook() {
        return isNotebook;
    }

    public int getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public String[] getDevices() {
        return devices;
    }

    public OS getOs() {
        return os;
    }
}
