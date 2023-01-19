package com.fabio.Condominio.enuns;

public enum StatusTaxaPagamento {
	
	ABERTO(0, "ABERTO"),
	pagoComDesconto(1, "pagoComDesconto"),
	pagoSemDesconto(2, "pagoSemDesconto");
	
	
	private Integer codigo;
	private String descricao;
	
	private StatusTaxaPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusTaxaPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusTaxaPagamento x : StatusTaxaPagamento.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Status inválido");
	}

}
