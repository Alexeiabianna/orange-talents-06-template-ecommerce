package com.alexei.mercadolivre.controller.dto;

import java.math.BigDecimal;

import com.alexei.mercadolivre.models.Produto;

public class DetalhesDto {

    private String nomeProduto;
    private BigDecimal preco;
    private String descricao;

    public DetalhesDto(Produto produto) {
        this.nomeProduto = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
