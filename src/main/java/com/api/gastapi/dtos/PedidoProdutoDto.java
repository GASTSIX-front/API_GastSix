package com.api.gastapi.dtos;

import java.util.UUID;

public record PedidoProdutoDto(
        UUID id_pedidoproduto,
        UUID id_pedido,
        UUID id_produto,
        int quantidade_produto
) {
}
