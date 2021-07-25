package com.alexei.mercadolivre.controller.form;

public enum TipoGateway {
    PAYPAL("paypal.com?buyerId={idGeradoDaCompra}&redirectUrl={urlRetornoAppPosPagamento}"),
    PAGSEGURO(" pagseguro.com?returnId={idGeradoDaCompra}&redirectUrl={urlRetornoAppPosPagamento}");

    private String url;

    private TipoGateway(String tipo) {
        this.url = tipo;
    }

    public String getUrl() {
        return url;
    }

}
