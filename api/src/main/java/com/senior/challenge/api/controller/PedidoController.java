package com.senior.challenge.api.controller;

import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.dto.DadosCadastroPedido;
import com.senior.challenge.api.dto.DadosDelhamentoPedido;
import com.senior.challenge.api.repository.PedidoRepository;
import com.senior.challenge.api.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity salvarPedido(@RequestBody @Valid DadosCadastroPedido dadosCadastroPedido){
        Pedido pedido = produtoService.criarPedido(dadosCadastroPedido);
        return ResponseEntity.ok(new DadosDelhamentoPedido(pedido));
    }
}
