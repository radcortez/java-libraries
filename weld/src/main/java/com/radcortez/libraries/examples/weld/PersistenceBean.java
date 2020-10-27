package com.radcortez.libraries.examples.weld;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersistenceBean {
    public void persistenceMethod() {
        System.out.println("PersistenceBean.persistenceMethod");
    }
}
