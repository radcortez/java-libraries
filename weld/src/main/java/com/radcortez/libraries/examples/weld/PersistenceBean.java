package com.radcortez.libraries.examples.weld;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersistenceBean {
    public void persistenceMethod() {
        System.out.println("PersistenceBean.persistenceMethod");
    }
}
