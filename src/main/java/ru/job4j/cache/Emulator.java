package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    private static final String MENU = """
                Введите 1. Загрузить содержимое файла в кэш
                Введите 2. Получить содержимое файла из кэша
                Введите любое другое число для выхода.
            """;

    private static final int PUT_CACHE = 1;

    private static final int GET_CACHE = 2;

    private static String inputFileName(Scanner scanner) {
        System.out.print("Введите имя файла: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите кэшируемую директорию: ");
        DirFileCache cache = new DirFileCache(scanner.nextLine());
        String fileName;
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (userChoice == PUT_CACHE) {
                fileName = inputFileName(scanner);
                cache.put(fileName, cache.get(fileName));
                System.out.println("Файл загружен в кэш");
            } else if (userChoice == GET_CACHE) {
                fileName = inputFileName(scanner);
                System.out.println("Файл получен из кэша ");
                System.out.println(cache.get(fileName));
            } else {
                run = false;
            }
        }
    }
}
