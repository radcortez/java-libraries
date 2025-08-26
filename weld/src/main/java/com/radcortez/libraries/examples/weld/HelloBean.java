package com.radcortez.libraries.examples.weld;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;

@Singleton
public class HelloBean {
    public void printHello(@Observes ContainerInitialized event) {
        System.out.println("HelloBean.printHello");
    }
}
