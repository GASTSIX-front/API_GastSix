package com.api.gastapi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FornecedorDto(
        @NotBlank
        String nome,
        @NotBlank
        String cnpj,

        @Email(message = "O email deve estar no formato válido")
        @NotBlank
        String email,

        String inscricao_estadual,
        String razao_social,
        String endereco
) {
}
