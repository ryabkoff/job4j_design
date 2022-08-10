package ru.job4j.ood.lsp.example22;

class Account {
    public double getInterest(double sum, int month, int rate) {
        if (sum < 0 || month > 12 || month < 1 || rate < 0) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        double result = sum;
        for (int i = 0; i < month; i++) {
            result += result * rate / 100;
        }
        if (sum >= 1000) {
            result += 100;
        }
        return result;
    }
}

class MicroAccount extends Account {
    @Override
    public double getInterest(double sum, int month, int rate) {
        if (sum < 0 || month > 12 || month < 1 || rate < 0) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        double result = sum;
        for (int i = 0; i < month; i++) {
            result += result * rate / 100;
        }
        return result;
    }
}
/*
В данном случае ослабляется постусловие, что является нарушением принципа LSP
 */
public class Example22 {
    public static void main(String[] args) {
        Account acc = new MicroAccount();
        double sum = acc.getInterest(1000, 1, 10);
        if (sum != 1200) {
            throw new IllegalArgumentException("Неожиданная сумма при вычислениях");
        }
    }
}
