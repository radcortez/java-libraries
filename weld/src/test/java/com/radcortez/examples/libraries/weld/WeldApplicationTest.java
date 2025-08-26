package com.radcortez.examples.libraries.weld;

import com.radcortez.libraries.examples.weld.BusinessBean;
import org.jboss.weld.environment.se.StartMain;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.inject.spi.CDI;

public class WeldApplicationTest {
    @Test
    void weld() {
        StartMain.main(new String[]{});

        CDI.current().select(BusinessBean.class).get().businessMethod();
    }
}
