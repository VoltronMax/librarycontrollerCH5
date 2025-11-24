package com.manueld.librarycontroller.controller;

import java.util.List;

import org.springframework.http.MediaType;
import com.manueld.librarycontroller.model.Book;
import com.manueld.librarycontroller.service.BookService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/libros")
public class BookController {

    private BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book b){
        return service.create(b);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Book GetABookById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @PutMapping("/{id}")
    public Book updateBook(Long id, @RequestBody @Valid Book b) {
        return service.updateBook(id, b);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBook(id);
    }

    @GetMapping("/buscar/")
    public List<Book> getBooksThatContains(@RequestParam String texto) {
        return service.searchByText(texto);
    }

    @PatchMapping("/devolver/{id}")
    public Book returnABorrowedBook(@PathVariable Long id){
        return service.returnABook(id);
    }

    @PatchMapping("/prestar/{id}")
    public Book borrowAbookAvailable(@PathVariable Long id){
        return service.borrowABook(id);
    }
    
    
}
