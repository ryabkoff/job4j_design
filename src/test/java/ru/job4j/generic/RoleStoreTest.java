package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddAndFindThenNameIsEngineer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        Role result = store.findById("1");
        assertThat(result.getName(), is("Engineer"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindNameIsEngineer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.add(new Role("1", "Accounter"));
        Role result = store.findById("1");
        assertThat(result.getName(), is("Engineer"));
    }

    @Test
    public void whenReplaceThenNameIsAccounter() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.replace("1", new Role("1", "Accounter"));
        Role result = store.findById("1");
        assertThat(result.getName(), is("Accounter"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.replace("10", new Role("10", "Accounter"));
        Role result = store.findById("1");
        assertThat(result.getName(), is("Engineer"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenNameIsEngineer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getName(), is("Engineer"));
    }
}