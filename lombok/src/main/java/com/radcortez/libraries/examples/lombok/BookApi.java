package com.radcortez.libraries.examples.lombok;

import lombok.experimental.Delegate;

public class BookApi {
    private static final BookApi BOOK_API = new BookApi();

    @Delegate
    private final BookService bookService = new BookService();

    public static BookApi getInstance() {
        return BOOK_API;
    }
}
