package com.felipe.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double edition;
    private String publicationYear;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book_author",
            joinColumns =
                    {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    private List<Author> authors = new ArrayList<>();

    public Book(String name, Double edition, String publicationYear) {
        this.name = name;
        this.edition = edition;
        this.publicationYear = publicationYear;
    }

    public Book() {

    }

}
