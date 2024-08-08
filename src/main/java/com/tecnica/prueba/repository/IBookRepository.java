package com.tecnica.prueba.repository;

import com.tecnica.prueba.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByNombre(String nombre);
}
