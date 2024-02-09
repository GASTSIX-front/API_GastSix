package com.api.gastapi.repositories;

import com.api.gastapi.models.PedidoProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProdutoModel, UUID> {
}
