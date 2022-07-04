package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), visitor);
        Map<FileProperty, List<Path>> files = visitor.getFiles();
        for (FileProperty file : files.keySet()) {
            List<Path> paths = files.get(file);
            if (paths.size() > 1) {
                System.out.printf("%s - %s%n", file.getName(), file.getSize());
                for (Path path : paths) {
                    System.out.println(path);
                }
            }
        }
    }
}