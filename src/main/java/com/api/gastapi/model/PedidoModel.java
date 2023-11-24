package com.api.gastapi.model;

import com.api.gastapi.dto.PedidoAtualizacaoDto;
import com.api.gastapi.dto.PedidoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "pedido")
@Entity(name = "Pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PedidoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id_pedido;
    private String observacoes;
    private String usuario_operador;
    private String usuario_supervisor;
    private String setor;

    public PedidoModel(PedidoDto dados){
        this.observacoes = dados.observacoes();
        this.usuario_operador = dados.usuario_operador();
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
