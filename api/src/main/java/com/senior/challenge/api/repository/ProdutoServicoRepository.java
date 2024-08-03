package com.senior.challenge.api.repository;

import com.senior.challenge.api.domain.ProdutoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, UUID> {
}
