package com.manueld.librarycontroller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manueld.librarycontroller.model.Book;
import com.manueld.librarycontroller.model.Status;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository){
        this.repository = repository;

    }

    @Override
    public Book create(Book b) {
        if(b.getAuthor()==null){
            b.setAuthor("Desconocido");
        }
        repository.add(b);
        return b;
    }

    @Override
    public List<Book> getAll() {
        return repository.getAll();
        
    }

    @Override
    public Book getById(Long id) {
        var tempbook = repository.findById(id);
        if (tempbook == null){
            throw new IllegalArgumentException("El libro no fue encontrado");
        }
        return tempbook;
    }

    @Override
    public Book updateBook(Long id, Book b) {
        var temp = getById(id);
        temp.setAuthor(b.getAuthor());
        temp.setGenre(b.getGenre());
        temp.setTitle(b.getTitle());
        return temp;
    }

    @Override
    public void deleteBook(Long id) {
        var temp = getById(id);
        repository.deleteById(temp.getId());
    }

    @Override
    public List<Book> searchByText(String content) {
        if(content == null || content.isBlank()){
            return repository.getAll();
        }

        return repository.getAll().stream()
            .filter(c -> c.getTitle().toLowerCase().contains(content.toLowerCase())
                || c.getAuthor().toLowerCase().contains(content.toLowerCase()))
            .toList();
    }

    @Override
    public Book borrowABook(Long id) {
        var temp = getById(id);
        temp.setStatus(Status.BORROWED);
        return temp;
        
    }
    @Override
    public Book returnABook(Long id) {
        var temp = getById(id);
        temp.setStatus(Status.AVAILABLE);
        return temp;
    }
}
