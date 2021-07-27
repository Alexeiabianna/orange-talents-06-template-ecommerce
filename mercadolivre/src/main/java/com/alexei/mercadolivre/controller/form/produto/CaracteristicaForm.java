package com.alexei.mercadolivre.controller.form.produto;

import javax.validation.constraints.NotBlank;

import com.alexei.mercadolivre.models.Caracteristica;
import com.alexei.mercadolivre.models.Produto;

public class CaracteristicaForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public CaracteristicaForm() {
    }

    public CaracteristicaForm(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Caracteristica toModel(Produto produto) {
        return new Caracteristica(nome, descricao, produto);
    }
}
