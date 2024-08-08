package com.tecnica.prueba.DTO;

import jakarta.validation.constraints.NotBlank;

public record CreateBookDTO(
            @NotBlank
            String nombre,
            String autor,
            String editorial,
            String fecha_publicacion
) {
}
