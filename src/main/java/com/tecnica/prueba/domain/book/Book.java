package com.tecnica.prueba.domain.book;

import com.tecnica.prueba.DTO.CreateBookDTO;
import com.tecnica.prueba.domain.detbook.DetBook;
import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DetBook detalle_libro;

    public Book(CreateBookDTO createBookDTO) {
        this.nombre = createBookDTO.nombre();
        if (createBookDTO.autor() != null || createBookDTO.editorial() != null || createBookDTO.fecha_publicacion() != null) {
            this.detalle_libro = new DetBook(createBookDTO.autor(), createBookDTO.editorial(), createBookDTO.fecha_publicacion());
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}