package com.alexei.mercadolivre.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.alexei.mercadolivre.models.Categoria;
import com.alexei.mercadolivre.models.Produto;

import org.hibernate.validator.constraints.Length;

public class ProdutoForm {

    @NotBlank
    private String nome;

    @Positive
    @NotNull
    private BigDecimal valor;

    @Positive
    @NotNull
    private Integer quantidade;

    @Length(max = 1000)
    private String descricao;

    @NotNull
    private Long idCategoria;

    @Size(min = 3)
    private List<CaracteristicaForm> caracteristicas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public List<CaracteristicaForm> getCaracteristicas() {
        return caracteristicas;
    }

    public boolean isEqualNomeCaracteristica(List<CaracteristicaForm> list) {
        HashSet<String> checkNome = new HashSet<>();

        for (CaracteristicaForm s : list) {
            if (!checkNome.add(s.getNome())) {
                return true;
            }
        }
        return false;
    }

    public Produto toModel(Categoria categoria) {
        return new Produto(this.nome, this.valor, this.quantidade, this.descricao, this.caracteristicas, categoria);
    }

}
