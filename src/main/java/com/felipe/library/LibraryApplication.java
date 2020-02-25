package com.felipe.library;

import com.felipe.library.entity.Author;
import com.felipe.library.entity.Book;
import com.felipe.library.repository.AuthorRepository;
import com.felipe.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book1 = new Book("Livro 1", 2.5, "2020");
		Book book2 = new Book("Livro 2", 2.5, "2020");
		Book book3 = new Book("Livro 3", 2.5, "2020");

		Author author1 = new Author("Felipe Melo", "078");
		Author author2 = new Author("Felipe Melo 2", "078");
		Author author3 = new Author("Felipe Melo 3", "078");

		book1.getAuthors().addAll(Arrays.asList(author1, author2));
		book2.getAuthors().addAll(Arrays.asList(author1, author2));
		book3.getAuthors().addAll(Arrays.asList(author2, author3));

		author1.getBooks().addAll(Arrays.asList(book1, book2));
		author2.getBooks().addAll(Arrays.asList(book1, book2, book3));
		author3.getBooks().addAll(Arrays.asList(book2, book3));

		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
		authorRepository.saveAll(Arrays.asList(author1, author2, author3));
	}
}
