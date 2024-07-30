package com.senior.challenge.api.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "itens_pedido")
@Entity(name = "ItemPedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedido {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "produto_servico_id", nullable = false)
    private ProdutoServico produtoServico;
}