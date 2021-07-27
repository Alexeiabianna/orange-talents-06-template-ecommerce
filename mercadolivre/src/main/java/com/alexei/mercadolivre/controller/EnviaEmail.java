package com.alexei.mercadolivre.controller;

import com.alexei.mercadolivre.models.Pergunta;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;

import org.springframework.stereotype.Component;

@Component
public interface EnviaEmail {
    void enviaEmail(Pergunta pergunta, Usuario usuario);
    
    void enviaEmail(Produto produto, Usuario usuario);
}
