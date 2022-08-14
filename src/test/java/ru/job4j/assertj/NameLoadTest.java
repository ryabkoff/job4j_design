package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkParseNotContainsEqual() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key<>12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol");
    }

    @Test
    void checkParseStartsWithEqual() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void checkParseEndsWithEqual() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value");
    }
}