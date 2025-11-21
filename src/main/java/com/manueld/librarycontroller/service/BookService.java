package com.manueld.librarycontroller.service;

import java.util.List;

import com.manueld.librarycontroller.model.Book;

public interface BookService {
    
    /**Operaciones CRUD a través de Endpoints REST:
POST /api/libros: Crear un nuevo libro en el sistema.
GET /api/libros: Obtener un listado de todos los libros.
GET /api/libros/{id}: Obtener los detalles de un libro específico por su ID.
PUT /api/libros/{id}: Actualizar la información de un libro existente identificado por su ID.
DELETE /api/libros/{id}: Eliminar un libro por su ID.
Operaciones Adicionales:
GET /api/libros/buscar?q={textoBusqueda}: Buscar libros cuyo título o autor contengan el texto proporcionado.
(Opcional, para ir más allá) POST /api/libros/{id}/prestar: Marcar un libro específico como "Prestado". */

Book create(Book b);
List<Book> getAll();
Book getById(Long id);
Book updateBook(Long id, Book b);
void deleteBook(Long id);
List<Book>searchByText(String content);
Book borrowABook(Long id);
Book returnABook(Long id);
}
