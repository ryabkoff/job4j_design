package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonToPojoUsage {
    public static void main(String[] args) {
        JSONObject jsonOs = new JSONObject("{\"name\":\"Windows 10\"}");
        List<String> list = new ArrayList<>();
        list.add("mouse");
        list.add("keyboard");
        JSONArray jsonDevices = new JSONArray(list);
        Computer computer = new Computer(false,
                8,
                "Intel i3 8100",
                new String[] {"mouse", "keyboard"},
                new OS("Windows 10"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notebook", computer.isNotebook());
        jsonObject.put("ram", computer.getRam());
        jsonObject.put("cpu", computer.getCpu());
        jsonObject.put("cpu", computer.getCpu());
        jsonObject.put("os", jsonOs);
        jsonObject.put("devices", jsonDevices);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(computer));

    }
}
