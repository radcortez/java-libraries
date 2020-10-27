package com.radcortez.libraries.examples.faker;

import com.github.javafaker.DragonBall;
import com.github.javafaker.Faker;
import com.github.javafaker.Superhero;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class FakerTest {
    private final static Faker FAKER = Faker.instance();

    @Test
    void books() {
        Stream.generate(FAKER::book).limit(10).forEach(System.out::println);
    }

    @Test
    void heroes() {
        Stream.generate(FAKER::superhero).limit(10).map(Superhero::name).forEach(System.out::println);
    }

    @Test
    void dragonball() {
        Stream.generate(FAKER::dragonBall).limit(10).map(DragonBall::character).forEach(System.out::println);
    }


}
