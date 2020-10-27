package com.radcortez.libraries.examples.weld;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;

@Singleton
public class HelloBean {
    public void printHello(@Observes ContainerInitialized event) {
        System.out.println("HelloBean.printHello");
    }
}
