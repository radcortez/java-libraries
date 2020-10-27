package com.radcortez.libraries.examples.config;

import org.eclipse.microprofile.config.spi.Converter;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class DurationConverter implements Converter<Duration> {
    private static final long serialVersionUID = 7499347081928776532L;
    private static final String PERIOD_OF_TIME = "PT";
    private static final Pattern DIGITS = Pattern.compile("^[-+]?\\d+$");
    private static final Pattern START_WITH_DIGITS = Pattern.compile("^[-+]?\\d+.*");

    @Override
    public Duration convert(String value) {
        value = value.trim();
        if (value.isEmpty()) {
            return null;
        }
        if (DIGITS.asPredicate().test(value)) {
            return Duration.ofSeconds(Long.parseLong(value));
        }

        try {
            if (START_WITH_DIGITS.asPredicate().test(value)) {
                return Duration.parse(PERIOD_OF_TIME + value);
            }

            return Duration.parse(value);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
