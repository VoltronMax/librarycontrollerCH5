package com.manueld.librarycontroller.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Schema(description = "Nombre del autor del libro. Por ej: Julio Verne (Si el libro no tiene autor, se le asignara Desconocido")
    private String author;

    @Schema(description = "ISBN del libro de 13 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "Solo se permiten numeros en el ISBN")
    @Size(min = 13, max = 13, message = "El ISBN debe ser exactamente de 13 digitos")
    @NotBlank(message = "El ISBN no puede estar vacio")
    private String isbn;

    @Schema(description = "Genero del libro. Ej: SCI_FI = Ciencia ficcion")
    @NotNull
    private Genre genre;

    @Schema(description = "Estado actual del libro")
    private Status status;

    public Book(){}

    public Book(String title,
            String author,
            String isbn,
            Genre genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
}
