package ru.job4j.ood.isp.example1;

/*
Данный отчет требуется формировать только в Excel формате,
а реализовывать приходится оба метода, в этом нарушение принципа
ISP. Решением является ращделение на отдельные интерфейсы.
 */
public class OSVReport implements Report {
    @Override
    public void generateExcel() {

    }

    @Override
    public void generatedPdf() {

    }
}
