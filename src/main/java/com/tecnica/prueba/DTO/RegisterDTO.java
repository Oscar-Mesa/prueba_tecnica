package com.tecnica.prueba.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank String name,
        @NotBlank String lastname,
        @Email @NotBlank String email,
        @NotBlank String password
) {
}
