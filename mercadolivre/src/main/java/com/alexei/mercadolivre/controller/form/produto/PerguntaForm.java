package com.alexei.mercadolivre.controller.form.produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.alexei.mercadolivre.models.Pergunta;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;

public class PerguntaForm {

    @NotBlank
    @Size(max = 30)
    private String titulo;
    @NotBlank
    @Size(max = 500)
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
