package com.api.gastapi.dto;

import com.api.gastapi.model.PedidoModel;

import java.util.UUID;

public record PedidoListagemDto(
        UUID id_pedido,
        String observacoes,
        String usuario_operador,
        String usuario_supervisor,
        String setor
) {
    public PedidoListagemDto(PedidoModel pedido){
        this(pedido.getId_pedido(), pedido.getObservacoes(), pedido.getUsuario_operador(), pedido.getUsuario_supervisor(), pedido.getSetor());
    }
}
