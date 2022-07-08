package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUsage {
    public static void main(String[] args) {
        Computer computer = new Computer(false,
                8,
                "Intel i3 8100",
                new String[] {"mouse", "keyboard"},
                new OS("Windows 10"));

        final Gson gson = new GsonBuilder().create();
        String jSonString = gson.toJson(computer);
        System.out.println(jSonString);

        Computer computerFromJson = gson.fromJson(jSonString, Computer.class);
        System.out.println(computer);
        System.out.println(computerFromJson);
    }
}
