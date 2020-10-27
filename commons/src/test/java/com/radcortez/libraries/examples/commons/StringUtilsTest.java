package com.radcortez.libraries.examples.commons;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {
    @Test
    void blank() {
        final String name = null;

        assertThrows(NullPointerException.class, () -> name.isBlank());

        assertTrue(StringUtils.isBlank(name));
    }


}
