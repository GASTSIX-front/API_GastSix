package com.api.gastapi.dtos;

import com.api.gastapi.models.PedidoModel;

public record DetalhamentoPedidoDto(
        String observacoes,
        String usuario_supervisor,
        String setor
) {
    public DetalhamentoPedidoDto(PedidoModel pedido){
        this(pedido.getObservacoes(), pedido.getUsuario_supervisor(), pedido.getSetor());
    }
}
