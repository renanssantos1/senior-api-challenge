package com.senior.challenge.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_servico_id", nullable = false)
    private ProdutoServico produtoServico;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
}
