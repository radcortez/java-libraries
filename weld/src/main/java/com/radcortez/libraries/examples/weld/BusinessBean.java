package com.radcortez.libraries.examples.weld;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BusinessBean {
    @Inject
    PersistenceBean persistenceBean;

    public void businessMethod() {
        System.out.println("BusinessBean.businessMethod");
        persistenceBean.persistenceMethod();
    }
}
