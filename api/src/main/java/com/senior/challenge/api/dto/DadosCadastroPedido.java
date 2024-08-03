package com.senior.challenge.api.dto;

import com.senior.challenge.api.domain.Status;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPedido(

        @NotNull
        Status status,

        @NotNull
        Double desconto
) {
}
