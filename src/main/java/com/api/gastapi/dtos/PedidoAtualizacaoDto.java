package com.api.gastapi.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PedidoAtualizacaoDto(
        @NotNull
        UUID id_pedido,
        String observacoes,
        String setor
) {
}
