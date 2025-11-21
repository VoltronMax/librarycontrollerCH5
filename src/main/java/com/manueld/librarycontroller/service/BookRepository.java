package com.manueld.librarycontroller.service;

import java.util.List;

import com.manueld.librarycontroller.model.Book;

public interface BookRepository {

    Book add(Book b);

    Book findById(Long id);

    List<Book> getAll();

    void deleteById(Long id);
}
