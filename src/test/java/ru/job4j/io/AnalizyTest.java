package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenLogContainsTwoAvailableInt() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(s -> rsl.append(rsl.length() != 0 ? System.lineSeparator() : "").append(s));
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01"
                + System.lineSeparator()
                + "11:01:02;11:02:02"));
    }

    @Test
    public void whenLogContainsOnlyUnavailableInt() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 11:01:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(s -> rsl.append(rsl.length() != 0 ? System.lineSeparator() : "").append(s));
        }
        assertThat(rsl.toString(), is("10:57:01"));
    }

    @Test
    public void whenLogContainsOnlyAvailableInt() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:57:01");
            out.println("300 10:58:01");
            out.println("200 11:01:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(s -> rsl.append(rsl.length() != 0 ? System.lineSeparator() : "").append(s));
        }
        assertThat(rsl.toString(), is(""));
    }
}