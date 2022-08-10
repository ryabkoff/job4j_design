package ru.job4j.ood.lsp.example33;

class Account {
    protected  int capital;

    Account(int sum) {
        if (sum < 100) {
            throw new IllegalArgumentException("Некорректная сумма");
        }
        this.capital = sum;
    }

    public void setCapital(int sum) {
        if (sum < 100) {
            throw new IllegalArgumentException("Некорректная сумма");
        }
        this.capital = sum;
    }
}

class MicroAccount extends Account {
    MicroAccount(int sum)  {
        super(sum);
    }

    @Override
    public void setCapital(int sum) {
        this.capital = sum;
    }
}
/*
Здесь проявление инвариантности, при установке свойства capital для класса MicroAccount
не производится проверка как в его предке Account
 */
public class Example33 {
    public static void main(String[] args) {
        Account acc = new MicroAccount(100);
        acc.setCapital(10);
    }
}
