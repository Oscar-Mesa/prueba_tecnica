package com.tecnica.prueba.controller;

import com.tecnica.prueba.DTO.CreateBookDTO;
import com.tecnica.prueba.domain.book.Book;
import com.tecnica.prueba.repository.IBookRepository;
import com.tecnica.prueba.response.ResponseBookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Book", description = "CRUD Book")
public class BookController {
    private final IBookRepository iBookRepository;

    public BookController(IBookRepository iBookRepository){
        this.iBookRepository = iBookRepository;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Registrar libro", security = @SecurityRequirement(name = "bearer-key"))
    public ResponseEntity<?>PostBook(@RequestBody @Valid CreateBookDTO createBookDTO, UriComponentsBuilder uriComponentsBuilder){
        Optional<Book> libroExistente = iBookRepository.findByNombre(createBookDTO.nombre());
        if (libroExistente.isPresent()){
            String mensajeError ="Este libro ya se encuentra registrado";
            return ResponseEntity.badRequest().body(mensajeError);
        }
        Book book = new Book(createBookDTO);
        iBookRepository.save(book);
        ResponseBookDTO responseBookDTO =
            new ResponseBookDTO(
                book.getId(),
                book.getNombre()
            );
        URI url = uriComponentsBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(url).body(responseBookDTO);
    }

}
