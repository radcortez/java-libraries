package com.radcortez.libraries.examples.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    private Long id;
    private String author;
    private String title;
    private Integer year;
    private String genre;
    private String isbn;

    @Builder(toBuilder = true)
    public Book(final String author, final String title, final Integer year, final String genre, final String isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.isbn = isbn;
    }
}
