package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String period = "";
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                String[] s = line.split(" ", 2);
                if (period.isBlank() && ("400".equals(s[0]) || "500".equals(s[0]))) {
                    period = s[1];
                } else if (!period.isBlank() && ("200".equals(s[0]) || "300".equals(s[0]))) {
                    out.println(period + ";" + s[1]);
                    period = "";
                }
            }
            if (!period.isBlank()) {
                out.println(period);
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