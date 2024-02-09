package com.api.gastapi.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pedidoproduto")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PedidoProdutoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedidoproduto", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private ProdutoModel produto;

//    @EmbeddedId
//    PedidoProdutoChaveModel id;
//
//    @ManyToOne
//    @MapsId("id_pedido")
//    @JoinColumn(name = "id_pedido")
//    @JsonIgnore
//    private PedidoModel pedido;
//
//    @ManyToOne
//    @MapsId("id_produto")
//    @JoinColumn(name = "id_produto")
//    @JsonIgnore
//    private ProdutoModel produto;

    private int quantidade_produto;
}