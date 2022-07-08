package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
public class OS {
    @XmlAttribute
    private String name;

    public OS() {
    }

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
