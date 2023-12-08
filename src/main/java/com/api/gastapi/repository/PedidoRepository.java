package com.api.gastapi.repository;

import com.api.gastapi.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {
}
