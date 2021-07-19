package com.alexei.mercadolivre.controller.form;

import com.alexei.mercadolivre.models.Usuario;

import org.springframework.stereotype.Component;

@Component
public interface EnviaEmail {
    void enviaEmail(String mensagem, Usuario usuario);
}
