package com.felipe.library.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipe.library.entity.Author;
import com.felipe.library.entity.Book;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AuthorDTO {

    private Integer id;
    private String name;
    private String cpf;
    private List<Book> books = new ArrayList<>();

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.cpf = author.getCpf();
        this.books = author.getBooks();
    }

    public static List<AuthorDTO> converter(List<Author> authors){
        return authors.stream().map(AuthorDTO::new).collect(Collectors.toList());
    }

}
