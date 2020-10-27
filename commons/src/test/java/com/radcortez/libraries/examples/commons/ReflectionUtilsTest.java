package com.radcortez.libraries.examples.commons;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionUtilsTest {
    @Test
    void reflection() {
        final User user = new User();
        try {
            final Field firstName = User.class.getDeclaredField("firstName");
            firstName.setAccessible(true);
            firstName.set(user, "Roberto");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals("Roberto", user.getFirstName());

        try {
            FieldUtils.writeField(user, "lastName", "Cortez", true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals("Cortez", user.getLastName());
    }

    static class User {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(final String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(final String lastName) {
            this.lastName = lastName;
        }
    }
}
