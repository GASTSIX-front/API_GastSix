package com.api.gastapi.repositories;

import com.api.gastapi.models.FornecedorModel;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, UUID>{
}
