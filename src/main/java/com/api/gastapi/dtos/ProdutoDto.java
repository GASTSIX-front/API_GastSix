package com.api.gastapi.dtos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record ProdutoDto(
        @NotBlank String descricao,
        @NotBlank String partnumber,
        @NotBlank String setor,
        String codigoSAP
) {
}
