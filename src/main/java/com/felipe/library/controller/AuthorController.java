package com.felipe.library.controller;

import com.felipe.library.entity.Author;
import com.felipe.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> findAllAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping(value = "/{id}")
    public Author findAuthorById(@PathVariable Integer id){
        return authorService.findAuthorById(id);
    }

    @PostMapping
    public void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthor(id);
    }


}
