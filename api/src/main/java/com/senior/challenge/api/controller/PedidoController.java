package com.senior.challenge.api.controller;

import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.dto.DadosCadastroPedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @PostMapping
    public ResponseEntity salvarPedido(@RequestBody DadosCadastroPedido dadosPedido){
        Pedido pedido = new Pedido(dadosPedido);

        return ResponseEntity.ok(pedido);
    }
}
