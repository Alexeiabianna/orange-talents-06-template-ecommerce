package com.alexei.mercadolivre.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    private List<Caracteristica> caracteristicas = new ArrayList<>();

    @ManyToOne
    private Categoria categoria;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private Set<ImagemProduto> imagens = new HashSet<>();

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, BigDecimal valor, Integer quantidade, String descricao,
            List<Caracteristica> caracteristicas, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.caracteristicas.addAll(caracteristicas);
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void vinculaImagens(Set<String> listaLinks) {

        Set<ImagemProduto> lista = listaLinks.stream().map(link -> new ImagemProduto(this, link))
                .collect(Collectors.toSet());

        this.imagens.addAll(lista);

    }

}
