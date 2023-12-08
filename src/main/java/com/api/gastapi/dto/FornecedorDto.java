package com.api.gastapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record FornecedorDto<TipoModel>(
        @NotBlank String cnpj,

        @Email(message = "O email deve estar no formato válido") String email,

        String inscrição_estadual,
        String razao_social,
        String endereco,
        String numero,
        String bairro,
        String cep,

        TipoModel tipo_fornecedor,

        MultipartFile imagem
) {
}
