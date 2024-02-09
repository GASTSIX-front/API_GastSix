package com.api.gastapi.models;

import com.api.gastapi.dtos.PedidoAtualizacaoDto;
import com.api.gastapi.dtos.PedidoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Table(name = "pedido")
@Entity(name = "Pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PedidoModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_pedido;
    private String observacoes;
    private String usuario_supervisor;
    private String setor;

    @OneToMany(mappedBy = "pedido")
    Set<PedidoProdutoModel> pedidoProduto;

    public PedidoModel(PedidoDto dados){
        this.observacoes = dados.observacoes();
        this.usuario_supervisor = dados.usuario_supervisor();
        this.setor = dados.setor();
    }

    public void atualizarInformacoes(PedidoAtualizacaoDto dados){
        if(dados.observacoes() != null){
            this.observacoes = dados.observacoes();
        }
        if(dados.setor() != null){
            this.setor = dados.setor();
        }
    }

}
