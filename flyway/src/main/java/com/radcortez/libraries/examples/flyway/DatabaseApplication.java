package com.radcortez.libraries.examples.flyway;

import org.flywaydb.core.Flyway;

public class DatabaseApplication {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", null, null).load();
        flyway.migrate();
    }
}
