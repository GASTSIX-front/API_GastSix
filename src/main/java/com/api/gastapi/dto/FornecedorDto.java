package com.api.gastapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

//usuario dto faz-se alteraçao dentro do parenteses
public record FornecedorDto(
        //criar atributos que vai receber do fornecedor;
        //para a conexao com o model os nomes dos atributos devem ser iguais;

        //@Notblank o atributo nao pode ser em branco(é obrigatorio preencher);
        @NotBlank String nome,
        @NotBlank String cnpj,
        @Email(message = "O email deve estar no formato válido") String email,
        String inscricao_estadual,
        String razao_social,
        String endereco
) {
}
