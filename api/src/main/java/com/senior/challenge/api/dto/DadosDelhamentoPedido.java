package com.senior.challenge.api.dto;

import com.senior.challenge.api.domain.ItemPedido;
import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.domain.Status;

import java.util.List;
import java.util.UUID;

public record DadosDelhamentoPedido(
        UUID id,
        Status status,
        Double desconto,
        List<ItemPedido> itemPedidos
) {
    public DadosDelhamentoPedido(Pedido pedido){
        this(pedido.getId(), pedido.getStatus(), pedido.getDesconto(), pedido.getItensPedido());
    }
}
