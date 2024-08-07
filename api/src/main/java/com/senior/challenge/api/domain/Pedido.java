package com.senior.challenge.api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.senior.challenge.api.dto.DadosCadastroPedido;
import com.senior.challenge.api.dto.DadosCadastroPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    public Pedido(DadosCadastroPedido dados) {
        this.desconto = dados.desconto();
        this.status = dados.status();
        this.itensPedido = new ArrayList<>(dados.itensPedido());
    }
}