package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        paramValidation(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void paramValidation(String[] params) {
        if (params.length != 2) {
            throw new IllegalArgumentException("Invalid number of parameters. There must be two, "
                    + "1 - start dir, 2 - extension");
        }
        File file = new File(params[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException("Strart dir doesn't exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Start dir isn't directory");
        }
        if (!params[1].startsWith(".")) {
            throw new IllegalArgumentException("Extension doesn't start with '.'");
        }
    }
}