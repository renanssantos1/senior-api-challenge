package com.senior.challenge.api.service;

import com.senior.challenge.api.domain.ItemPedido;
import com.senior.challenge.api.domain.Pedido;
import com.senior.challenge.api.domain.ProdutoServico;
import com.senior.challenge.api.dto.DadosCadastroPedido;
import com.senior.challenge.api.repository.PedidoRepository;
import com.senior.challenge.api.repository.ProdutoServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    public Pedido criarPedido(DadosCadastroPedido dadosCadastroPedido){
        var pedido = new Pedido(dadosCadastroPedido);
        pedido.setStatus(dadosCadastroPedido.status());
        pedido.setDesconto(dadosCadastroPedido.desconto());

        List<ItemPedido> itensPedido = new ArrayList<>();
        for (ItemPedido itemDTO : dadosCadastroPedido.itensPedido()) {
            ProdutoServico produtoServico;
            if (itemDTO.getProdutoServico().getId() != null) {
                produtoServico = produtoServicoRepository.findById(itemDTO.getProdutoServico().getId())
                        .orElseThrow(() -> new EntityNotFoundException("ProdutoServico não encontrado"));
            } else {
                produtoServico = new ProdutoServico();
                produtoServico.setNome(itemDTO.getProdutoServico().getNome());
                produtoServico.setPreco(itemDTO.getProdutoServico().getPreco());
                produtoServico.setAtivo(itemDTO.getProdutoServico().getAtivo());
                produtoServico.setIsProduto(itemDTO.getProdutoServico().getIsProduto());
                produtoServicoRepository.save(produtoServico);
            }

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(itemDTO.getQuantidade());
            itemPedido.setProdutoServico(produtoServico);
            itemPedido.setPedido(pedido);

            itensPedido.add(itemPedido);
        }

        pedido.setItensPedido(itensPedido);
        return pedidoRepository.save(pedido);
    }

}
