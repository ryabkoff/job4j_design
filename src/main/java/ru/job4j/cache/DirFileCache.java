package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader read = new BufferedReader(
                new FileReader(String.format("%s/%s", cachingDir, key)))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (!sb.isEmpty()) {
                    sb.append(System.lineSeparator());
                }
                sb.append(line);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return sb.toString();
    }
}