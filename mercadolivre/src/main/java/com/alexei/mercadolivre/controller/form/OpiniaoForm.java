package com.alexei.mercadolivre.controller.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alexei.mercadolivre.models.Opiniao;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;

public class OpiniaoForm {

    @NotNull
    @Min(1) @Max(5)
    private Integer nota;

    @NotBlank @Size(max = 50)
    private String titulo;

    @NotBlank @Size(max = 500)
    private String descricao;

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Opiniao toModel(Usuario usuario, Produto produto) {
        return new Opiniao(this.nota, this.titulo, this.descricao, usuario, produto);
    }

}
