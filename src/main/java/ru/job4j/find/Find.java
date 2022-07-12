package ru.job4j.find;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Find {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            showHint();
        } else {
            ArgsName argsName = ArgsName.of(args);
            validation(argsName);
            SearchFiles searcher = new SearchFiles(condition(argsName.get("t"), argsName.get("n")));
            Files.walkFileTree(Paths.get(argsName.get("d")), searcher);
            List<Path> paths = searcher.getPaths();
            try (PrintWriter out = new PrintWriter(new FileWriter(argsName.get("o")))) {
                paths.forEach(out::println);
            }
        }
    }

    private static Predicate<Path> condition(String t, String n) {
        Predicate<Path> cond;
        if ("name".equals(t)) {
            cond = path -> path.getFileName()
                    .toString()
                    .equals(n);
        } else if ("mask".equals(t)) {
            cond = path -> path.getFileName()
                    .toString()
                    .matches(n.replace(".", "[.]")
                            .replace("?", ".?")
                            .replace("*", ".*?"));
        } else {
            cond = path -> path.getFileName()
                    .toString()
                    .matches(n);
        }
        return cond;
    }

    private static void validation(ArgsName argsName) {
        String d = argsName.get("d");
        File file = new File(d);
        if (!file.exists()) {
            throw  new IllegalArgumentException(String.format("Path '%s' doesn't exist!", d));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("'%s' isn't a directory", d));
        }
        argsName.get("n");
        String t = argsName.get("t");
        if (!"mask".equals(t)
                && !"name".equals(t)
                && !"regex".equals(t)) {
            throw new IllegalArgumentException("'-t' must be 'mask', 'name' or 'regex'");
        }
        argsName.get("o");
    }

    private static void showHint() {
        System.out.println("find.jar -d=directory -n=filter -t=type -o=output" + System.lineSeparator()
                + "-d start directory for search" + System.lineSeparator()
                + "-n filebane, mask or regex" + System.lineSeparator()
                + "-t search type, by name, mask or regex" + System.lineSeparator()
                + "-o output file for result");
    }
}
