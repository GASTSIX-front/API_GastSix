package com.api.gastapi.repositories;

import com.api.gastapi.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
    ProdutoModel findByPartnumber(String partnumber);
}
