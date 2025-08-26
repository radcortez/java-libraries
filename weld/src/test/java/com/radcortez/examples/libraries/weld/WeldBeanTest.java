package com.radcortez.examples.libraries.weld;

import com.radcortez.libraries.examples.weld.BusinessBean;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import jakarta.inject.Inject;

@ExtendWith(WeldJunit5AutoExtension.class)
public class WeldBeanTest {
    @Inject
    BusinessBean businessBean;

    @Test
    void business() {
        businessBean.businessMethod();
    }
}
