package com.alexei.mercadolivre.controller;

import com.alexei.mercadolivre.models.Compra;

public interface EventoCompraConcluida {
    void processa(Compra compra);
}
