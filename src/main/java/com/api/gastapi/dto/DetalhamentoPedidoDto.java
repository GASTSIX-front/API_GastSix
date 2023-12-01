package com.api.gastapi.dto;

import com.api.gastapi.model.PedidoModel;

public record DetalhamentoPedidoDto(
        String observacoes,
        String usuario_operador,
        String usuario_supervisor,
        String setor
) {
    public DetalhamentoPedidoDto(PedidoModel pedido){
        this(pedido.getObservacoes(), pedido.getUsuario_operador(), pedido.getUsuario_operador(), pedido.getSetor());
    }
}
