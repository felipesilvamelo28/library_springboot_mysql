package com.felipe.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cpf;
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Author(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }
        public Author() {

    }

}

