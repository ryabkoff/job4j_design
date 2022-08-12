package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {
    public static final int ADD = 1;
    public static final int PRINT = 2;
    public static final int EXIT = 3;
    public static final String MSG = """
            1. Добавить новый элемент меню
            2. Напечатать меню
            3. Выход
            """;

    public static final String PARENT_MSG = """
            Введите имя родителя, 
            чтобы добавить в корневое меню введите ROOT
            """;
    public static final String CHILD_MSG = """
            Введите имя
            """;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select = 0;
        String parentName;
        String childName;
        Menu menu = new SimpleMenu();
        while (select != EXIT) {
            System.out.println(MSG);
            select = sc.nextInt();
            if (select == ADD) {
                System.out.println(PARENT_MSG);
                parentName = sc.next();
                System.out.println(CHILD_MSG);
                childName = sc.next();
                menu.add("ROOT".equals(parentName) ? Menu.ROOT : parentName,
                        childName,
                        null);
            } else if (select == PRINT) {
                SimpleMenuPrinter simpleMenuPrinter = new SimpleMenuPrinter();
                simpleMenuPrinter.print(menu);
            }
        }
    }
}
