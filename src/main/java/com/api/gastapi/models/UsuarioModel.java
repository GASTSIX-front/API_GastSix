package com.api.gastapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.io.Serial;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula", nullable = false)

    private String matricula;
    private String email;
    private String cpf;

    private String nome;
    @JsonIgnore
    private String senha;

    private TipoModel funcao;

    @Temporal(TemporalType.DATE)
    private Date data_admissao;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.funcao == TipoModel.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_SUPERVISOR"),
                    new SimpleGrantedAuthority("ROLE_OPERADOR")
            );
        } else if (this.funcao == TipoModel.SUPERVISOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_SUPERVISOR")
            );
        } else if (this.funcao == TipoModel.OPERADOR) {
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

}