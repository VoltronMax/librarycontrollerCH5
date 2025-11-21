package com.manueld.librarycontroller.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.manueld.librarycontroller.model.Book;

/**
 *  Clase que implementa la logica de una base de datos simulada
 *  en memoria usando los metodos de la interfaz BookRepository
 */

@Repository
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book>books;
    private AtomicLong contador;

    public BookRepositoryImpl(){
        books = new HashMap<>();
        contador = new AtomicLong();
    }

/**
 *  Metodo que asigna un ID unico a un libro y lo agrega a la base de datos simulada (Map)
 *  @param Book Recibe un libro con sus atributos ya definidos por su constructor
 *  @return Devuelve el libro agregado al mapa con un ID asignado
 */
    @Override
    public Book add(Book b) {
        b.setId(contador.getAndIncrement());
        books.put(b.getId(), b);
        return b;
    }

    /**
     * Metodo que busca en el map un libro que coincida con un id ingresado
     * @param id Identificador unico del libro a buscar
     * @return El libro que coincide con el ID ingresado
     */
    @Override
    public Book findById(Long id) {
        return books.get(id);
    }

    /**
     * Metodo que muestra todos los libros almacenados
     * @return Una lista con todos los libros del mapa
     */
    @Override
    public List<Book> getAll() {
        return books.values().stream().toList();
        }

    /**
     * Metodo que elimina de la lista un libro con el ID ingresado
     *  @param id Identificador unico del libro a eliminar
     */
    @Override
    public void deleteById(Long id) {
        books.remove(findById(id).getId());
    }
}
