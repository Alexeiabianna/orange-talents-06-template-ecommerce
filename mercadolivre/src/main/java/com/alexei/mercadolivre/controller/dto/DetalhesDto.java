package com.alexei.mercadolivre.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.IntStream;

import com.alexei.mercadolivre.models.Produto;

public class DetalhesDto {

    private String nomeProduto;
    private BigDecimal preco;
    private String descricao;
    private List<DetalheProdutoCaracteristica> caracteristicas = new ArrayList<>();
    private List<String> linkImagens;
    private SortedSet<String> perguntas;
    private Set<Map<String, String>> opinioes;
    private double media;
    private Integer totalNotas;

    public DetalhesDto(Produto produto) {
        this.nomeProduto = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();
        this.caracteristicas = produto.mapeiaCaracteristicas(DetalheProdutoCaracteristica::new);
        this.linkImagens = produto.mapeiaImagens(imagem -> imagem.getLinkImagem());
        this.perguntas = produto.mapeiaPerguntas(pergunta -> pergunta.getTitulo());
        this.opinioes = produto.mapeiaOpiniao(opiniao -> {
            return Map.of("titulo", opiniao.getTitulo(), "descricao", opiniao.getDescricao());
        });

        Set<Integer> notas = produto.mapeiaOpiniao(opiniao -> opiniao.getNota());
        IntStream mapToInt = notas.stream().mapToInt(nota -> nota);

        OptionalDouble mediaNotas = mapToInt.average();
        if(mediaNotas.isPresent()) {
            this.media = mediaNotas.getAsDouble();
        }

        this.totalNotas = opinioes.size();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<DetalheProdutoCaracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public List<String> getLinkImagens() {
        return linkImagens;
    }

    public SortedSet<String> getPerguntas() {
        return perguntas;
    }

    public Set<Map<String, String>> getOpinioes() {
        return opinioes;
    }

    public Double getMedia() {
        return media;
    }

    public Integer getTotalNotas() {
        return totalNotas;
    }

}
