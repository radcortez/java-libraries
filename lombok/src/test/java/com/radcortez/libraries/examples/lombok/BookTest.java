package com.radcortez.libraries.examples.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {
    @Test
    void book() {
        Book book = Book.builder()
                        .author("Roberto Cortez")
                        .title("Do you know these libraries?")
                        .year(2020)
                        .genre("Technology")
                        .isbn("1234567890")
                        .build();

        assertEquals("Roberto Cortez", book.getAuthor());
        book.setAuthor("Roberto");
        assertEquals("Roberto", book.getAuthor());
        System.out.println("book = " + book);
    }

    @Test
    void bookNew() {
        Book book = Book.builder()
                        .author("Roberto Cortez")
                        .title("Do you know these libraries?")
                        .year(2020)
                        .genre("Technology")
                        .isbn("1234567890")
                        .build();

        Book newBook = book.toBuilder().author("Roberto").build();
        assertNotEquals(book, newBook);
    }
}
