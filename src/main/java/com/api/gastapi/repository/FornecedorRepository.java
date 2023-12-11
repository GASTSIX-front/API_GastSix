package com.api.gastapi.repository;

import com.api.gastapi.model.FornecedorModel;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, UUID>{
}
