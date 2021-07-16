package com.alexei.mercadolivre.controller.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OpiniaoForm {

    @NotNull
    @Min(1) @Max(5)
    private Integer nota;

    @NotBlank @Size(max = 50)
    private String titulo;

    @NotBlank @Size(max = 500)
    private String descricao;

    @NotNull
    private Long idProduto;

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getIdProduto() {
        return idProduto;
    }

}
