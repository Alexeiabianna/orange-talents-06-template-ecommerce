package com.alexei.mercadolivre.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.alexei.mercadolivre.models.Compra;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.StatusCompra;
import com.alexei.mercadolivre.models.Usuario;

public class CompraForm {

    @NotNull
    private Long idProduto;
    @NotNull
    @Max(1)
    private Integer tipoPagamento;
    @NotNull
    @Positive
    private Integer quantidade;
    @NotNull
    private BigDecimal valor;

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Compra toModel(Produto produto, Usuario comprador) {
        return new Compra(this.quantidade, comprador, produto, valor, tipoPagamento, StatusCompra.INICIADA);
    }

}
