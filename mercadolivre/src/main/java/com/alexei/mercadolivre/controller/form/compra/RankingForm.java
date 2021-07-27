package com.alexei.mercadolivre.controller.form.compra;

import javax.validation.constraints.NotNull;

public class RankingForm {

    @NotNull
    private Long idCompra;
    @NotNull
    private Long idDonoProduto;

    public RankingForm(Long idCompra, Long idDonoProduto) {
        this.idCompra = idCompra;
        this.idDonoProduto = idDonoProduto;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public Long getIdDonoProduto() {
        return idDonoProduto;
    }

}
