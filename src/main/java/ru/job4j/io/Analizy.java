package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    class Period {
        String start;
        String finish;

        Period(String start, String finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    public void unavailable(String source, String target) {
        List<Period> periods = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            boolean isOpen = false;
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                String[] s = line.split(" ", 2);
                if (!isOpen && ("400".equals(s[0]) || "500".equals(s[0]))) {
                    periods.add(new Period(s[1], ""));
                    isOpen = true;
                } else if (isOpen && ("200".equals(s[0]) || "300".equals(s[0]))) {
                    periods.get(periods.size() - 1).finish = s[1];
                    isOpen = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (Period period : periods) {
                out.println(period.start + ";" + period.finish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
    }
}