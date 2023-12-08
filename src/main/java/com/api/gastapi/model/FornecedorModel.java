package com.api.gastapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_fornecedores")
public class FornecedorModel implements Serializable, UseDetails {
    @Serial
    private static final long seriaVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fornecedor", nullable = false)
    private UUID id;
    private String cnpj;
    private String email;
    private String inscrição_estadual;
    private String razão_social;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;

    private TipoModel tipo_fornecedor;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){

    }

}
