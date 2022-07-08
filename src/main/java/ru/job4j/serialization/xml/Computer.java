package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "computer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Computer {
    @XmlAttribute
    private boolean isNotebook;
    @XmlAttribute
    private int ram;
    @XmlAttribute
    private String cpu;
    private String[] devices;
    private OS os;

    public Computer() {
    }

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
}
