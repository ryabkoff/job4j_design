package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return storage.replace(id, storage.get(id), model);
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id, storage.get(id));
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }

    public static void main(String[] args) {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("1", "Ivanov");
        User user2 = new User("2", "Petrov");
        User user3 = new User("3", "Sidorov");
        mem.add(user1);
        mem.add(user2);
        mem.add(user3);
        boolean dds = mem.replace("2", user3);
        boolean ff = mem.delete("1");
        User u = mem.findById("2");

        int d = 0;
    }
}