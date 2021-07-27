package com.alexei.mercadolivre.controller.form.compra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.alexei.mercadolivre.models.Compra;
import com.alexei.mercadolivre.models.StatusTransacao;
import com.alexei.mercadolivre.models.Transacao;

public class PagSeguroForm implements RespostaGateway {
    @NotBlank
    private String idTransacao;
    @NotNull
    private StatusPagSeguro status;

    public PagSeguroForm(String idTransacao, StatusPagSeguro status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public StatusPagSeguro getStatus() {
        return status;
    }

    @Override
    public Transacao toModel(Compra compra) {
        StatusTransacao statusResposta = this.status.equals(StatusPagSeguro.SUCESSO) ? StatusTransacao.sucesso : StatusTransacao.falha;
        return new Transacao(idTransacao, statusResposta, compra);        
    }

}
