package com.api.gastapi.repositories;

import com.api.gastapi.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository<UserDetails> extends JpaRepository<UsuarioModel, UUID> {
    UserDetails findByEmail(String email);
}