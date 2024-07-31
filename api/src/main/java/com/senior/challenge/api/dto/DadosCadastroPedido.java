package com.senior.challenge.api.dto;

import com.senior.challenge.api.domain.ItemPedido;
import com.senior.challenge.api.domain.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroPedido(

        @NotBlank
        Status status,

        @NotBlank
        Double desconto,

        @NotNull
        @Valid
        List<ItemPedido> itensPedido
) {
}
