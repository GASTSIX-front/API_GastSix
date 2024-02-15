package com.api.gastapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class ProdutoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto", nullable = false)
    private UUID id;

    private String descricao;
    private String partnumber;
    private String setor;
    private String codigoSAP;
//    private String url_img;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    Set<PedidoProdutoModel> pedidoProduto;


}