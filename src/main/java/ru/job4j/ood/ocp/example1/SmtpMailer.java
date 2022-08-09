package ru.job4j.ood.ocp.example1;

import ru.job4j.ood.ocp.example1.Logger;

public class SmtpMailer {
    /*
    1. Здесь используется конкретная реализация вместо абстракции,
    logger записывает данные в файл, если понадобится записывать
    в базу данных, то придется создавать новый класс и придется
    изменять SmtpMailer для этого.
     */
    private final Logger logger;

    public SmtpMailer() {
        logger = new Logger();
    }

    public void sendMessage(String message) {
        logger.log(String.format("Отправлено %s", message));
    }
}