package com.alexei.mercadolivre.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.alexei.mercadolivre.controller.form.compra.RespostaGateway;
import com.alexei.mercadolivre.controller.form.compra.TipoGateway;

import io.jsonwebtoken.lang.Assert;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoGateway tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusCompra status;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Usuario comprador;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
    private Set<Transacao> transacoes = new HashSet<>();

    @Deprecated
    public Compra() {
    }

    public Compra(Integer quantidade, Usuario comprador, Produto produto, BigDecimal valor, Integer tipoPagamento,
            StatusCompra status) {
        this.quantidade = quantidade;
        this.comprador = comprador;
        this.produto = produto;
        this.valor = valor;
        this.tipoPagamento = selectGateway(tipoPagamento);
        this.status = status;
    }

    private TipoGateway selectGateway(Integer tipoPagamento) {
        if (tipoPagamento.equals(0)) {
            return TipoGateway.PAGSEGURO;
        }
        return TipoGateway.PAYPAL;
    }

    public Long getId() {
        return id;
    }

    public Integer getquantidade() {
        return quantidade;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoGateway getTipoPagamento() {
        return tipoPagamento;
    }

    public StatusCompra getStatus() {
        return status;
    }

    public boolean isValidEstoque(Integer quantidade) {
        return this.produto.getQuantidade() > quantidade;
    }

    public void updateEstoque() {
        this.produto.setQuantidade(quantidade);
    }

    public void addTransacao(RespostaGateway respostaGateway) {
        Transacao transacao = respostaGateway.toModel(this);
        Assert.isTrue(!this.transacoes.contains(transacao), "Essa transacao já foi registrada" + transacao);

        this.transacoes.add(transacao);

    }

    private Set<Transacao> transacoesConcluidas() {
        Set<Transacao> transacoesConcluidas = this.transacoes.stream().filter(Transacao::isSucesso)
                .collect(Collectors.toSet());

        Assert.isTrue(transacoesConcluidas.size() <= 1, "Compra com mais de uma transacao concluida");

        return transacoesConcluidas;
    }

    public boolean isConcluida() {
        return !transacoesConcluidas().isEmpty();
    }

}
