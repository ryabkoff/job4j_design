package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        int added = 0;
        int changed = 0;
        String name;
        for (User user : current) {
            name = map.get(user.getId());
            if (name == null) {
                added++;
            } else if (!name.equals(user.getName())) {
                changed++;
            }
            map.remove(user.getId());
        }
        return new Info(added, changed, map.size());
    }

    public static void main(String[] args) {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        User u4 = new User(4, "D");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u4);
        Info info = diff(previous, current);
    }
}