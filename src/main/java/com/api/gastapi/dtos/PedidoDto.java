package com.api.gastapi.dtos;

import jakarta.validation.constraints.NotBlank;


public record PedidoDto(
        String observacoes,
        @NotBlank String usuario_operador,
        @NotBlank String usuario_supervisor,
        String setor

) {
}
