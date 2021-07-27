package com.alexei.mercadolivre.controller.form.compra;

import javax.validation.constraints.NotNull;

public class NotaFiscalForm {
    @NotNull
	private Long idCompra;
	@NotNull
	private Long idComprador;

	public NotaFiscalForm(Long idCompra, Long idComprador) {
		this.idCompra = idCompra;
		this.idComprador = idComprador;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public Long getIdComprador() {
		return idComprador;
	}

}
