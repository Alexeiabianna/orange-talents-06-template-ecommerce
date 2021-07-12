package com.alexei.mercadolivre.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;
    
    private String caracteristicas;
    
    private String categoria;


    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, BigDecimal valor, Integer quantidade, String descricao, String caracteristicas,
            String categoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.caracteristicas = caracteristicas;
        this.categoria = categoria;
    }
    
    
}
