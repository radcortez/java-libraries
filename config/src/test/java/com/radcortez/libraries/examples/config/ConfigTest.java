package com.radcortez.libraries.examples.config;

import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigTest {
    @BeforeAll
    static void beforeAll() {
        System.setProperty("port", "9090");
    }

    @Test
    void config() {
        Config config = ConfigProvider.getConfig();

        assertEquals("localhost", config.getValue("server.host", String.class));
        assertEquals(9090, config.getValue("server.port", Integer.class));
    }

    @Test
    void mapping() {
        SmallRyeConfig config = (SmallRyeConfig) ConfigProvider.getConfig();
        Server server = config.getConfigMapping(Server.class);

        assertEquals("localhost", server.host());
        assertEquals(9090, server.port());
        assertEquals(Duration.ofSeconds(60), server.timeout());
        assertEquals(200, server.threads());

        assertEquals("login.html", server.form().get("login-page"));
        assertEquals("error.html", server.form().get("error-page"));
        assertEquals("index.html", server.form().get("landing-page"));

        assertTrue(server.ssl().isPresent());
        assertEquals(8443, server.ssl().get().port());
        assertEquals(Stream.of("TLSv1.3", "TLSv1.2").collect(toList()), server.ssl().get().protocols());

        assertFalse(server.proxy().isPresent());

        assertFalse(server.log().enabled());
        assertEquals(".log", server.log().suffix());
        assertTrue(server.log().rotate());
        assertEquals(Server.Log.Pattern.COMMON, server.log().pattern());
    }
}
