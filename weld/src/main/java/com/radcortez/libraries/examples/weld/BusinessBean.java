package com.radcortez.libraries.examples.weld;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BusinessBean {
    @Inject
    PersistenceBean persistenceBean;

    public void businessMethod() {
        System.out.println("BusinessBean.businessMethod");
        persistenceBean.persistenceMethod();
    }
}
