package com.api.gastapi.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PedidoProdutoChaveModel implements Serializable {
    private UUID id_pedido;
    private UUID id_produto;
//    private int quantidade_produto

}