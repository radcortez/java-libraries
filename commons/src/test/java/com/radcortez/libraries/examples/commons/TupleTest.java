package com.radcortez.libraries.examples.commons;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TupleTest {
    @Test
    void tuple() {
        Map.Entry<String, String> pairEntry = Map.entry("a", "b");

        Pair<String, String> pair = Pair.of("a", "b");
        Triple<String, String, String> triple = Triple.of("a", "b", "c");
    }
}
