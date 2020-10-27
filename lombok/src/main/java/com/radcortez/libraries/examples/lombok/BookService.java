package com.radcortez.libraries.examples.lombok;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
public class BookService {
    @SneakyThrows
    public Book createBook(final String author, final String title) {
        validateAuthor(author);

        return Book.builder()
                   .author(author)
                   .title(title)
                   .build();
    }

    private void validateAuthor(@NonNull final String author) throws ValidationException {
        if (author.length() < 2) {
            log.info("Failed author validation!");
            throw new ValidationException("Author name length must be >= 2");
        }
    }

    public static class ValidationException extends Exception {
        public ValidationException(final String message) {
            super(message);
        }
    }
}
