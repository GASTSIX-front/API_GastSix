package com.api.gastapi.repository;

import com.api.gastapi.model.FornecedorModel;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.UserDetails;

@Repository
public interface FornecedorRepository extends  JpaRespository<FornecedorModel, UUID>{
    UserDetails findbyEmail(String email);

    void delete(fornecedorModel fornecedorModel);

    Object findAll();
}
