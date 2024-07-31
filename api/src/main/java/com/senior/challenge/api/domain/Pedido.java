package com.senior.challenge.api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.senior.challenge.api.dto.DadosCadastroPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Table(name = "pedidos")
@Entity(name = "Pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = true)
    private Double desconto;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemPedido> itensPedido;

    public Pedido(DadosCadastroPedido dadosPedido) {
        this.status = dadosPedido.status();
        this.desconto = dadosPedido.desconto();

        this.itensPedido = dadosPedido.itensPedido().stream()
                .map(dadosItem -> {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dadosItem.getQuantidade());
                    itemPedido.setPrecoUnitario(dadosItem.getPrecoUnitario());
                    itemPedido.setProdutoServico(dadosItem.getProdutoServico());
                    itemPedido.setPedido(this);
                    return itemPedido;
                })
                .collect(Collectors.toList());
    }
}
