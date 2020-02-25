package com.felipe.library.service;

import com.felipe.library.controller.dto.BookDTO;
import com.felipe.library.controller.dto.CreateBookDTO;
import com.felipe.library.entity.Author;
import com.felipe.library.entity.Book;
import com.felipe.library.repository.AuthorRepository;
import com.felipe.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;

    //Listar todos os Livros:

    public List<BookDTO> findAllBooks(){
        List<Book> books = bookRepository.findAll();
        return BookDTO.converter(books);
    }

    //Procurar Livro por ID:

    public Book findBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new RuntimeException("ID "+ id + ": Livro Inválido"));
    }

    //Criar Livro:

    public void createBook(CreateBookDTO bookDTO) {
        Book book = criarLivroComBookDTO(bookDTO);

        for(int c = 0; c < bookDTO.getAuthorsId().size(); c++){
            Author author = adicionaLivroAoAutor(bookDTO, book, c);
            book.getAuthors().add(author);
        }
        bookRepository.save(book);
    }

    //Deletar Livro

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    //Demais métodos:

    private Book criarLivroComBookDTO(CreateBookDTO bookDTO) {
        return new Book
                    (bookDTO.getName(),
                    bookDTO.getEdition(),
                    bookDTO.getPublicationYear());
    }

    private Author adicionaLivroAoAutor(CreateBookDTO bookDTO, Book book, int c) {
        Author author = authorService.findAuthorById(bookDTO.getAuthorsId().get(c));
        author.getBooks().add(book);
        authorRepository.save(author);
        return author;
    }

}
