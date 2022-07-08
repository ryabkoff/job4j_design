package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUsage {
    public static void main(String[] args) throws Exception {
        Computer computer = new Computer(false,
                8,
                "Intel i3 8100",
                new String[]{"mouse", "keyboard"},
                new OS("Windows 10"));
        JAXBContext context = JAXBContext.newInstance(Computer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(computer, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Computer result = (Computer) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
