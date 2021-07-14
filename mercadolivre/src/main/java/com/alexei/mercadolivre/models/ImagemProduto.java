package com.alexei.mercadolivre.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private String linkImagem;

    @Deprecated
    public ImagemProduto() {
    }

    public ImagemProduto(Produto produto, String linkImagem) {
        this.produto = produto;
        this.linkImagem = linkImagem;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

}
