package com.alexei.mercadolivre.controller.form;

import javax.validation.constraints.NotBlank;

import com.alexei.mercadolivre.config.validation.UniqueValue;
import com.alexei.mercadolivre.models.Categoria;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
    private Long idCategoriaMae;

    public CategoriaForm() {
    }

    public String getNome() {
        return this.nome;
    }

    public Long getIdCategoriaMae() {
        return this.idCategoriaMae;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }    
}
