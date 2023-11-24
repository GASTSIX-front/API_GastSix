package com.api.gastapi.dto;

import jakarta.validation.constraints.NotBlank;

public record PedidoDto(
        String observacoes,
        String usuario_operador,
        String usuario_supervisor,
        String setor

) {
}
