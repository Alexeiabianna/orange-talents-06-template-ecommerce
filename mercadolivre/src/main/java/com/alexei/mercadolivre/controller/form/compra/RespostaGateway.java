package com.alexei.mercadolivre.controller.form.compra;

import com.alexei.mercadolivre.models.Compra;
import com.alexei.mercadolivre.models.Transacao;

public interface RespostaGateway {
    Transacao toModel(Compra compra);
}
