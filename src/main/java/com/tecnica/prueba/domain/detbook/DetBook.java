package com.tecnica.prueba.domain.detbook;

import jakarta.persistence.*;

@Entity
@Table(name = "DetBook")
public class DetBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String editorial;
    private String fecha_publicacion;

    public DetBook() {
    }

    public DetBook(String autor, String editorial, String fecha_publicacion) {
        this.autor = autor;
        this.editorial = editorial;
        this.fecha_publicacion = fecha_publicacion;
    }
}
