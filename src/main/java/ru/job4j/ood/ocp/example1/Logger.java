package ru.job4j.ood.ocp.example1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Logger {
    private Path path;

    public Logger() {
    }

    public void log(String logText) {
        try {
            Files.writeString(path, logText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}