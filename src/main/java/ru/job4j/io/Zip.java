package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validate(ArgsName argsName) {
        String d = argsName.get("d");
        String e = argsName.get("e");
        argsName.get("o");
        File file = new File(d);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Directory %s does not exist", d));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("%s isn't directory", d));
        }
        if (!e.startsWith(".")) {
            throw new IllegalArgumentException(String.format("Extension '%s' doesn't start with '.'", e));
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        new Zip().packFiles(Search.search(Path.of(argsName.get("d")),
                path -> !path.toFile()
                        .getName()
                        .endsWith(argsName.get("e"))), new File(argsName.get("o")));
    }
}