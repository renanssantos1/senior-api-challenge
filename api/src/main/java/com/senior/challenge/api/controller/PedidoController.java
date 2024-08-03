package com.senior.challenge.api.controller;

import com.senior.challenge.api.dto.DadosListagemPedido;
import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.domain.Status;
import com.senior.challenge.api.dto.DadosCadastroPedido;
import com.senior.challenge.api.dto.DadosDelhamentoPedido;
import com.senior.challenge.api.repository.PedidoRepository;
import com.senior.challenge.api.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDelhamentoPedido> criarPedido(@RequestBody @Valid DadosCadastroPedido dados){
        Pedido pedido = pedidoService.criarPedido(dados);
        return ResponseEntity.ok(new DadosDelhamentoPedido(pedido));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPedido>> buscarPedidos(Pageable pagination){
        var page = repository.findAllByStatus(Status.ABERTO, pagination)
                .map(DadosListagemPedido::new);

        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPedidoPorId(@PathVariable UUID id){
        var pedido  = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDelhamentoPedido(pedido));
    }
}
