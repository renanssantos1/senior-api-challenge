package com.senior.challenge.api.repository;

import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    Page<Pedido>findAllByStatus(@Param("status") Status status, Pageable pageable);
}
