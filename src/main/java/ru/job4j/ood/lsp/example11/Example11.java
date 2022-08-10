package ru.job4j.ood.lsp.example11;

class Account {
    protected int capital;

    public void setCapital(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Нельзя положить на счет меньше 0");
        }
        this.capital = money;
    }
}

class MicroAccount extends Account {
    @Override
    public void setCapital(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Нельзя положить на счет меньше 0");
        }
        if (money > 100) {
            throw new IllegalArgumentException("Нельзя положить на счет больше 100");
        }
        this.capital = money;
    }
}

/*
нарушение принципа LSP
усиливаются предусловия в классе MicroAccount, поэтому при
при создании Account acc = new MicroAccount(); и вызове метода
setCapital возникает ошибка
 */
public class Example11 {
    public static void main(String[] args) {
        Account acc = new MicroAccount();
        acc.setCapital(200);
    }
}
