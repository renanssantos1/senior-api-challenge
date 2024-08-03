package com.senior.challenge.api.domain;

import java.util.UUID;

public record DadosListagemPedido(
        UUID id,
        Status status,
        Double desconto
) {
    public DadosListagemPedido(Pedido pedido){
        this(pedido.getId(), pedido.getStatus(), pedido.getDesconto());
    }
}
