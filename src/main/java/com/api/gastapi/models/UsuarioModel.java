package com.api.gastapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.io.Serial;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula", nullable = false)
    private String matricula;
    private String email;
    private String cpf;

    private String nome;
    @JsonIgnore
    private String senha;

    //private TipoModel funcao;

    private Date data_admissao;

   // private String url_img;
/*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipo_usuario == TipoModel.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_SUPERVISOR"),
                    new SimpleGrantedAuthority("ROLE_OPERADOR")
            );
        } else if (this.tipo_usuario == TipoModel.SUPERVISOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_SUPERVISOR")
            );
        } else if (this.tipo_usuario == TipoModel.OPERADOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_OPERADOR")
            );
        }
        return null;
    }

    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

 */
}