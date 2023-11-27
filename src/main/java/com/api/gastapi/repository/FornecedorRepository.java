package com.api.gastapi.repository;

import com.api.gastapi.model.FornecedorModel;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.security.core.userdetails.UserDetails;

@Repository //é uma notation
//extends JPARepository é uma herança,<tipo de dado que vai trabalhar e tipo de dado do id>
public interface FornecedorRepository extends JpaRepository<FornecedorModel, UUID>{

    FornecedorModel findByEmail(String email);
}
