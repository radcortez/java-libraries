package com.radcortez.libraries.examples.mapstruct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookMapperTest {
    @Test
    void toBookRead() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Roberto Cortez");
        book.setTitle("Do you know these libraries?");
        book.setYear(2020);
        book.setGenre("Technology");
        book.setIsbn("1234567890");

        Book bookCopy = new Book();
        bookCopy.setId(2L);
        BookMapper.INSTANCE.toBook(book, bookCopy);

        assertNotEquals(bookCopy.getId(), book.getId());
        assertEquals("Roberto Cortez", bookCopy.getAuthor());

        System.out.println("bookCopy = " + bookCopy);
    }

    @Test
    void toBook() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Roberto Cortez");
        book.setTitle("Do you know these libraries?");
        book.setYear(2020);
        book.setGenre("Technology");
        book.setIsbn("1234567890");

        BookRead bookRead = BookMapper.INSTANCE.toBookRead(book);
        assertEquals("Roberto Cortez", bookRead.getAuthor());
    }
}
