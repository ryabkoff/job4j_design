package ru.job4j.design.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXMLTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report xmlReport = new ReportXML(store);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String expect = String.format("""
                           <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                           <employees>
                               <employees>
                                   <fired>%s</fired>
                                   <hired>%s</hired>
                                   <name>%s</name>
                                   <salary>%s</salary>
                               </employees>
                           </employees>
                           """,
                sdf.format(worker.getHired().getTime()),
                sdf.format(worker.getFired().getTime()),
                worker.getName(),
                worker.getSalary());
        String sss = xmlReport.generate(em -> true);
        assertThat(xmlReport.generate(em -> true), is(expect));
    }
}