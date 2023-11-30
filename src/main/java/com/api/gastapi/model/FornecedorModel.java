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
@Table(name = "fornecedor") //colocar o nome igual o do bd
//serializable é a herança de uma interface de uma outra classe
public class FornecedorModel implements Serializable{

    @Serial//é uma configuração do serializable
    private static final long seriaVersionUID = 1L;
    //Configuração do ID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //pra gerar o id de forma automatica;
    @Column(name = "id_fornecedor", nullable = false)//associa ele á coluna do banco de dados(colocar o nome do jeito que está no banco);
    private UUID id;//private é o atributo UUID é o tipo, é necessário fazer o import do UUID;Colocar os atributos de acordo com o banco;
    private String nome;
    private String cnpj;
    private String email;
    private String inscricao_estadual;
    private String razao_social;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
}
