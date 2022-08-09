package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportJSONTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report jSonReport = new ReportJSON(store);
        String expect = String.format("[{\"name\":\"%s\","
                + "\"hired\":{\"year\":%s,"
                        + "\"month\":%s,"
                        + "\"dayOfMonth\":%s,"
                        + "\"hourOfDay\":%s,"
                        + "\"minute\":%s,"
                        + "\"second\":%s},"
                + "\"fired\":{\"year\":%s,"
                        + "\"month\":%s,"
                        + "\"dayOfMonth\":%s,"
                        + "\"hourOfDay\":%s,"
                        + "\"minute\":%s,"
                        + "\"second\":%s},"
                + "\"salary\":%s}]",
                worker.getName(),
                worker.getHired().get(Calendar.YEAR),
                worker.getHired().get(Calendar.MONTH),
                worker.getHired().get(Calendar.DAY_OF_MONTH),
                worker.getHired().get(Calendar.HOUR_OF_DAY),
                worker.getHired().get(Calendar.MINUTE),
                worker.getHired().get(Calendar.SECOND),
                worker.getFired().get(Calendar.YEAR),
                worker.getFired().get(Calendar.MONTH),
                worker.getFired().get(Calendar.DAY_OF_MONTH),
                worker.getFired().get(Calendar.HOUR_OF_DAY),
                worker.getFired().get(Calendar.MINUTE),
                worker.getFired().get(Calendar.SECOND),
                worker.getSalary());
        String ee = jSonReport.generate(em -> true);
        assertThat(ee, is(expect));
    }
}