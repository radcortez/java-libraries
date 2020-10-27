package com.radcortez.libraries.examples.test.containers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class RESTApplicationTest {
    @Container
    private static final GenericContainer<?> REST_API =
        new GenericContainer<>(DockerImageName.parse("docker-registry:5000/radcortez/number-api"))
            .withExposedPorts(8081);

    @Test
    void rest() {
        RestAssured.get("http://localhost:" + REST_API.getFirstMappedPort() + "/numbers/generate")
                   .then()
                   .statusCode(200);
    }
}
