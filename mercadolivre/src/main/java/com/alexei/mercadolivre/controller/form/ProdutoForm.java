package com.alexei.mercadolivre.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.alexei.mercadolivre.models.Caracteristica;
import com.alexei.mercadolivre.models.Categoria;
import com.alexei.mercadolivre.models.Produto;

public class ProdutoForm {

    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;

    private Long idCategoria;
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

    public List<Caracteristica> convert() {
        List<Caracteristica> list = new ArrayList<>();

        caracteristicas.forEach(s -> {
            list.add(new Caracteristica(s.getNome(), s.getDescricao()));
        });

        return list;
    }

    public Produto toModel(Categoria categoria) {
        return new Produto(this.nome, this.valor, this.quantidade, this.descricao, this.convert(), categoria);
    }

}
