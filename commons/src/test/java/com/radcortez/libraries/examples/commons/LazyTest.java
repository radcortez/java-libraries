package com.radcortez.libraries.examples.commons;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class LazyTest {
    @Test
    void lazy() throws Exception {
        new ExpensiveObject();

        final LazyExpensiveObject lazyExpensiveObject = new LazyExpensiveObject();
        lazyExpensiveObject.initialize();
    }

    static class ExpensiveObject {
        public ExpensiveObject() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class LazyExpensiveObject extends LazyInitializer<ExpensiveObject> {
        @Override
        protected ExpensiveObject initialize() throws ConcurrentException {
            return new ExpensiveObject();
        }
    }
}
