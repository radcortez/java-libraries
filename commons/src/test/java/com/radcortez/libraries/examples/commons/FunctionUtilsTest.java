package com.radcortez.libraries.examples.commons;

import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.stream.Streams;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionUtilsTest {
    @Test
    void functions() {
        final List<String> list = List.of("a", "b", "c");

        List<String> validated = list.stream().map(new Function<String, String>() {
            @Override
            public String apply(final String source) {
                try {
                    return convert(source);
                } catch (ValidationException e) {
                    throw new IllegalArgumentException();
                }
            }
        }).collect(Collectors.toList());

        List<String> collect =
            list.stream()
                .map(source -> Failable.apply(FunctionUtilsTest::convert, source))
                .collect(Collectors.toList());

        Streams.stream(list)
               .map(FunctionUtilsTest::convert)
               .collect(Collectors.toList());
    }

    static String convert(String source) throws ValidationException {
        if (source == null) {
            throw new ValidationException();
        }

        return source;
    }

    static class ValidationException extends Exception {

    }
}
