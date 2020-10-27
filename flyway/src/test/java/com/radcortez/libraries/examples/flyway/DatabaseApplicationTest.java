package com.radcortez.libraries.examples.flyway;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseApplicationTest {
    @Test
    void main() throws Exception {
        DatabaseApplication.main(new String[0]);

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")) {
            DSLContext jooq = DSL.using(conn);
            jooq.query("insert into users values ('97b8435f-3f02-4bd3-88cb-c973e903263e', 'Sasuke', 'Uchiha', 17)").execute();

            Result<Record> users = jooq.select().from("Users").fetch();
            assertEquals(2, users.size());
        }
    }
}
