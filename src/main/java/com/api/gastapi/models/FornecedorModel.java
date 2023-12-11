package com.api.gastapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "fornecedor")
public class FornecedorModel implements Serializable {
    @Serial
    private static final long seriaVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fornecedor", nullable = false)
    private UUID id;

    private String nome;
    private String cnpj;
    private String email;
    private String inscricao_estadual;
    private String razao_social;
    private String endereco;
}
