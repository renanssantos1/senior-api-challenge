package com.senior.challenge.api.dto;

import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.domain.Status;

import java.util.UUID;

public record DadosListagemPedido(
        UUID id,
        Status status,
        Double desconto,
        Double valorTotal
) {
    public DadosListagemPedido(Pedido pedido){
        this(pedido.getId(), pedido.getStatus(), pedido.getDesconto(), pedido.getValorTotal());
    }
}
