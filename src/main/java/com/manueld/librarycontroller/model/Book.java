package com.manueld.librarycontroller.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Esta clase representa un libro")
public class Book {

    //Dto
    @Schema(description = "Identificador unico generado automaticamente. Por ej: 1...")
    private Long id;

    @Schema(description = "Titulo del libro. Ej: La vuelta al mundo en 80 dias")
    @NotBlank(message = "El titulo del libro no puede estar vacio")
    private String title;

    @Schema(description = "Nombre del autor del libro. Por ej: Julio Verne")
    @NotBlank(message = "El nombre del autor no puede estar en blanco")
    private String author;

    @Schema(description = "ISBN del libro de 13 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "Solo se permiten numeros en el ISBN")
    @Size(min = 13, max = 13, message = "El ISBN debe ser exactamente de 13 digitos")
    @NotBlank(message = "El ISBN no puede estar vacio")
    private String isbn;

    @Schema(description = "")
    @NotBlank(message = "El genero del libro no puede estar vacio")
    private String genre;
    private Status status;

    public Book(){}

    public Book(String title,
            String author,
            String isbn,
            String genre,
            Status status) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book [id=" + id +
        "\ntitle=" + title +
        "\nauthor=" + author +
        "\nisbn=" + isbn +
        "\ngenre=" + genre +
        "\nstatus=" + status + "]";
    }

    



    



    
}
