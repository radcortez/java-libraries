package com.radcortez.libraries.examples.rest.assured;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class RESTApplicationTest {
    @BeforeAll
    static void beforeAll() throws Exception {
        RESTApplication.main();

        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.filters(
            (requestSpec, responseSpec, ctx) -> {
                return ctx.next(requestSpec, responseSpec);
            },
            new RequestLoggingFilter(),
            new ResponseLoggingFilter());
    }

    @Test
    void rest() {
        given()
            .queryParam("name", "Roberto")
            .get("/hello")
            .then()
            .statusCode(200)
            .body(equalTo("Hello Roberto!"));
    }
}
