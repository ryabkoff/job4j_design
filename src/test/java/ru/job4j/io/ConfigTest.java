package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Sergey"));
        assertThat(config.value("surname"), is("Ryabkov"));
    }

    @Test
    public void whenPairWithCommentAndEmptyString() {
        String path = "./data/pair_with_comment_and_empty_string.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Sergey"));
        assertThat(config.value("surname"), is("Ryabkov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutValue() {
        String path = "./data/pair_without_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Sergey"));
        assertThat(config.value("surname"), is(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutKey() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Sergey"));
        assertThat(config.value(""), is("Ryabkov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutKeyAndValue() {
        String path = "./data/pair_without_key_and_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Sergey"));
        assertThat(config.value(""), is(""));
    }

    @Test
    public void whenPairWithValueContainsEq() {
        String path = "./data/pair_with_value_contains_eq.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Sergey"));
        assertThat(config.value("surname"), is("Ryabkov=HH"));
    }

}