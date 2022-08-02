package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TemplateGeneratorTest {

    @Ignore
    @Test
    public void whenAllKeysInMap() {
        TemplateGenerator generator = new TemplateGenerator();
        Map<String, String> keys = Map.of("name", "Petr Arsentev", "subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Petr Arsentev, Who are you? ";
        String result = generator.produce(template, keys);
        assertThat(result).isEqualTo(expected);
    }

    @Ignore
    @Test
    public void whenKeyNotInMap() {
        TemplateGenerator generator = new TemplateGenerator();
        Map<String, String> keys = Map.of("name", "Petr Arsentev");
        String template = "I am a ${name}, Who are ${subject}?";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> generator.produce(template, keys));
    }

    @Ignore
    @Test
    public void whenExcessKeyInMap() {
        TemplateGenerator generator = new TemplateGenerator();
        Map<String, String> keys = Map.of("name", "Petr Arsentev",
                "subject", "you",
                "company", "job4j");
        String template = "I am a ${name}, Who are ${subject}?";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> generator.produce(template, keys));
    }
}