package com.senior.challenge.api.dto;

import com.senior.challenge.api.domain.ItemPedido;
import com.senior.challenge.api.domain.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroPedido(

        @NotNull
        Status status,

        @NotNull
        Double desconto,

        @NotNull
        @Valid
        List<ItemPedido> itensPedido
) {
}
