package com.api.gastapi.dtos;

import com.api.gastapi.models.PedidoModel;

import java.util.UUID;

public record PedidoListagemDto(
        UUID id_pedido,
        String observacoes,
        String usuario_supervisor,
        String setor
) {
    public PedidoListagemDto(PedidoModel pedido){
        this(pedido.getId_pedido(), pedido.getObservacoes(), pedido.getUsuario_supervisor(), pedido.getSetor());
    }
}
