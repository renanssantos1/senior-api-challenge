package com.senior.challenge.api.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name = "produtos_servicos")
@Entity(name = "ProdutoServico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoServico {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private  Boolean ativo;

    @Column(nullable = false)
    private Boolean isProduto;

    @OneToMany(mappedBy = "produtoServico")
    private List<ItemPedido> itensPedido;

}
