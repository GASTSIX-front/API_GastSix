package com.api.gastapi.dtos;
import com.api.gastapi.models.TipoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record UsuarioDto(

        @NotBlank String matricula,

        @NotBlank @Email(message = "O email deve estar no formato válido") String email,

        @NotBlank String cpf,

        @NotBlank String nome,

        @NotBlank String funcao,

        @NotBlank String senha,

        @NotBlank String data_admissao

) {
}