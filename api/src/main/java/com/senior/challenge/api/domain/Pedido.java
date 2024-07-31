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

    public Pedido(DadosCadastroPedido dadosCadastroPedido) {
        this.desconto = dadosCadastroPedido.desconto();
        this.status = dadosCadastroPedido.status();

        if (this.itensPedido != null) {
            for (ItemPedido item : this.itensPedido) {
                item.setPedido(this);
                item.setProdutoServico(item.getProdutoServico());
            }
        }
    }
}