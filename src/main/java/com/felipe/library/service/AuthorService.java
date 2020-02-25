package com.felipe.library.service;

import com.felipe.library.entity.Author;
import com.felipe.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    //Listar todos os Autores:

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    //Procurar Autor por ID:

    public Author findAuthorById(Integer id){
        Optional<Author> author = authorRepository.findById(id);
        return author.orElseThrow(() -> new RuntimeException("ID "+ id + ": Autor Inválido"));
    }

    //Criar Autor:

    public void createAuthor(Author author){
        //author.setId(null);
        authorRepository.save(author);
    }

    //Deletar Autor:

    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }
}
