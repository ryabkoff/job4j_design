package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    private static void validate(ArgsName argsName) {
        String path = argsName.get("path");
        argsName.get("delimiter");
        argsName.get("out");
        argsName.get("filter");
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File %s doesn't exist!", path));
        }
    }

    private static String getRow(List<String> row, List<Integer> columns, String delimiter) {
        StringJoiner sj = new StringJoiner(delimiter);
        for (Integer column : columns) {
            sj.add(row.get(column));
        }
        return sj.toString();
    }

    private static void fillColumns(List<Integer> columnsToPrint, List<String> row, String filter) {
        String[] columns = filter.split(",");
        for (int i = 0; i < row.size(); i++) {
            for (int j = 0; j < columns.length; j++) {
                if (row.get(i).equals(columns[j])) {
                    columnsToPrint.add(i);
                    break;
                }
            }
        }
    }

    public static void handle(ArgsName argsName) throws Exception {
        StringJoiner rsl = new StringJoiner(System.lineSeparator());
        try (Scanner scanner = new Scanner(new FileInputStream(argsName.get("path")))
                .useDelimiter(System.lineSeparator())) {
            boolean isTitle = true;
            List<Integer> col = new ArrayList<>();
            while (scanner.hasNext()) {
                List<String> row = new ArrayList<>();
                try (Scanner dataScanner = new Scanner(scanner.next())
                        .useDelimiter(argsName.get("delimiter"))) {
                    while (dataScanner.hasNext()) {
                        row.add(dataScanner.next());
                    }
                }
                if (isTitle) {
                    fillColumns(col, row, argsName.get("filter"));
                    isTitle = false;
                }
                rsl.add(getRow(row, col, argsName.get("delimiter")));
            }
        }
        if ("stdout".equals(argsName.get("out"))) {
            System.out.println(rsl);
        } else {
            try (PrintWriter out = new PrintWriter(new FileWriter(argsName.get("out")))) {
                out.println(rsl);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }
}