package ru.job4j.find;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(
                    String.format("Argument %s doesn't exist", key));
        }
        return values.get(key);
    }

    private void validate(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Wrong number of arguments, must be more than 0");
        }
        for (String arg : args) {
            String[] s = arg.split("=", 2);
            if (s.length != 2
                    || !s[0].startsWith("-")
                    || "-".equals(s[0])
                    || s[1].isBlank()) {
                throw new IllegalArgumentException(String.format("Incorrect argument '%s'. "
                        + "Arguments must be given as '-key=value'", arg));
            }
        }
    }
    private void parse(String[] args) {
        validate(args);
        for (String arg : args) {
            String[] s = arg.split("=", 2);
            values.put(s[0].substring(1), s[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}