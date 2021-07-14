package com.alexei.mercadolivre.controller.form;

import javax.validation.constraints.NotBlank;

import com.alexei.mercadolivre.models.Caracteristica;

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

    public Caracteristica toModel() {
        return new Caracteristica(this.nome, this.descricao);
    }
    
}
