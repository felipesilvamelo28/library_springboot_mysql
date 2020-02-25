package com.felipe.library.controller;

import com.felipe.library.controller.dto.BookDTO;
import com.felipe.library.controller.dto.CreateBookDTO;
import com.felipe.library.entity.Book;
import com.felipe.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookDTO> findAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/{id}")
    public Book findBookById(@PathVariable Integer id){
        return bookService.findBookById(id);
    }

    @PostMapping()
    public void saveBook(@RequestBody CreateBookDTO bookDTO){
        bookService.createBook(bookDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }

}
