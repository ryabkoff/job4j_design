package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class MultTable {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("mult.txt")) {
            for (int x = 1; x <= 9; x++) {
                for (int y = 1; y <= 9; y++) {
                    out.write((x * y + "\t").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
