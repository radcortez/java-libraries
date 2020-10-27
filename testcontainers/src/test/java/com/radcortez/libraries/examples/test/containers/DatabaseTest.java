package com.radcortez.libraries.examples.test.containers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class DatabaseTest {
    @Container
    private static final JdbcDatabaseContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres");

    @Test
    void database() throws Exception {
        try (Connection conn = DriverManager.getConnection(POSTGRES.getJdbcUrl(),
                                                           POSTGRES.getUsername(),
                                                           POSTGRES.getPassword())) {

            conn.prepareStatement("create table users (\n" +
                                  "    id varchar(255) not null,\n" +
                                  "    first_name varchar(255) not null,\n" +
                                  "    last_name varchar(255) not null,\n" +
                                  "    age integer not null,\n" +
                                  "    primary key (id)\n" +
                                  ");")
                .execute();

            conn.prepareStatement(
                "insert into users values ('3df5eeff-f93d-4036-b1aa-9e96a7a8820d', 'Naruto', 'Uzumaki', 17);")
                .execute();

            ResultSet resultSet = conn.prepareStatement("select * from users").executeQuery();
            resultSet.next();
            assertEquals("3df5eeff-f93d-4036-b1aa-9e96a7a8820d", resultSet.getString(1));
            assertEquals("Naruto", resultSet.getString(2));
            assertEquals("Uzumaki", resultSet.getString(3));
            assertEquals(17, resultSet.getInt(4));
        }
    }
}
