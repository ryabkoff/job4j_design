package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

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
        Gson gson = new GsonBuilder().create();
        String expect = String.format("[{\"name\":%s,\"hired\":%s,\"fired\":%s,\"salary\":%s}]",
                gson.toJson(worker.getName()),
                gson.toJson(worker.getHired()),
                gson.toJson(worker.getFired()),
                gson.toJson(worker.getSalary()));
        String ee = jSonReport.generate(em -> true);
        assertThat(ee, is(expect));
    }
}