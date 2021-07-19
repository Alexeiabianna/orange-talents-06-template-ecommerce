package com.alexei.mercadolivre.controller.form;

import com.alexei.mercadolivre.models.Pergunta;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;

public class PerguntaForm {

    private String titulo;
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Pergunta toModel(Usuario usuario, Produto produto) {
        return new Pergunta(titulo, usuario, produto, mensagem);
    }
}
