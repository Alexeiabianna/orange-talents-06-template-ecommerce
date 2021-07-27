package com.alexei.mercadolivre.controller.form.compra;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.alexei.mercadolivre.models.Compra;
import com.alexei.mercadolivre.models.StatusTransacao;
import com.alexei.mercadolivre.models.Transacao;

public class PaypalForm implements RespostaGateway{
    @NotBlank
    private String idTransacao;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer status;

    public PaypalForm(String idTransacao, Integer status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public Transacao toModel(Compra compra) {
        StatusTransacao statusResposta = this.status == 0 ? StatusTransacao.falha : StatusTransacao.sucesso;
        return new Transacao(idTransacao, statusResposta, compra);
    }
}
