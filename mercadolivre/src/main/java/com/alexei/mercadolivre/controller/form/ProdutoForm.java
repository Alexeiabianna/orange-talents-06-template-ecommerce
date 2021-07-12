package com.alexei.mercadolivre.controller.form;

import java.math.BigDecimal;

import com.alexei.mercadolivre.models.Caracteristicas;
import com.alexei.mercadolivre.models.Categoria;
import com.alexei.mercadolivre.models.Produto;

public class ProdutoForm {

    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;
    
    private String caracteristicas;
    
    private String categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Produto toModel() {
        return new Produto(nome, valor, quantidade, descricao, caracteristicas, categoria);
    }    

}
