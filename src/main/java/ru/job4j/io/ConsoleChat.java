package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private String randomPhrase(List<String> phrases) {
        return phrases.get((int) (Math.random() * phrases.size()));
    }

    public void run() {
        List<String> botPhrases = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        String userPhrase = "";
        boolean allowTalking = true;
        while (!OUT.equals(userPhrase)) {
            System.out.print("Юзер: ");
            userPhrase = console.nextLine();
            log.add(userPhrase);
            if (userPhrase.isBlank() || OUT.equals(userPhrase)) {
                continue;
            } else if (STOP.equals(userPhrase)) {
                allowTalking = false;
                continue;
            } else if (CONTINUE.equals(userPhrase)) {
                allowTalking = true;
                continue;
            }
            if (allowTalking) {
                String compPhrase = randomPhrase(botPhrases);
                log.add(compPhrase);
                System.out.println("Комп: " + compPhrase);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers,
                Charset.forName("windows-1251")))) {
            answers.addAll(br.lines().collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chatLog.txt", "botAnswers.txt");
        cc.run();
    }
}