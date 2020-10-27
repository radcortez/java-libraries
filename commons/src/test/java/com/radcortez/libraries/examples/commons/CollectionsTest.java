package com.radcortez.libraries.examples.commons;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionsTest {
    @Test
    void bag() {
        Bag<String> bag = new HashBag<>();
        bag.add("Naruto", 2);
        bag.add("Uzumaki", 3);

        assertEquals(5, bag.size());
        assertEquals(2, bag.getCount("Naruto"));
        assertEquals(3, bag.getCount("Uzumaki"));

        Set<String> unique = bag.uniqueSet();
        assertEquals(2, unique.size());
        assertTrue(unique.contains("Naruto"));
        assertTrue(unique.contains("Uzumaki"));
    }

    @Test
    void bidimap() {
        BidiMap<Integer, String> map = new TreeBidiMap<>();

        map.put(1, "Naruto");

        assertEquals("Naruto", map.get(1));
        assertEquals(1, map.inverseBidiMap().get("Naruto"));
    }
}
