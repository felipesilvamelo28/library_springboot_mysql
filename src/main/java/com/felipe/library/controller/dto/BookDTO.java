package com.felipe.library.controller.dto;

import com.felipe.library.entity.Author;
import com.felipe.library.entity.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BookDTO {
    private Integer id;
    private String name;
    private Double edition;
    private String publicationYear;
    private List<Author> authors = new ArrayList<>();

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.edition = book.getEdition();
        this.publicationYear = book.getPublicationYear();
        this.authors = book.getAuthors();
    }

    public static List<BookDTO> converter(List<Book> books){
        return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }

}
