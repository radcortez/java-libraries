package com.radcortez.libraries.examples.lombok;

import com.radcortez.libraries.examples.lombok.BookService.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookApiTest {
    @Test
    void createBook() {
        Book book = BookApi.getInstance().createBook("Roberto Cortez", "Do you know these libraries?");
        assertEquals("Roberto Cortez", book.getAuthor());
        System.out.println("book = " + book);
    }

    @Test
    void validateNull() {
        NullPointerException exception =
            assertThrows(NullPointerException.class, () -> BookApi.getInstance().createBook(null, null));
        System.out.println("exception.getMessage() = " + exception.getMessage());
    }

    @Test
    void validateLength() {
        final ValidationException exception =
            assertThrows(ValidationException.class, () -> BookApi.getInstance().createBook("X", "X"));
        System.out.println("exception.getMessage() = " + exception.getMessage());
    }
}
