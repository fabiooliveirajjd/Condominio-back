package com.fabio.Condominio.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fabio.Condominio.enuns.StatusTaxaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Taxa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTaxa;

	@Column
	private StatusTaxaPagamento statusTaxaPagamento;

	@Column
	private BigDecimal valor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento;

	@Column
	private Integer idCondomino;

	@Transient
	private String nomeCondomino;

	@Transient
	private String unidadeCondomino;

	public Taxa() {
		super();
	}

	public Taxa(Integer idTaxa, StatusTaxaPagamento statusTaxaPagamento, BigDecimal valor, LocalDate dataPagamento,
			Integer idCondomino, String nomeCondomino, String unidadeCondomino) {
		super();
		this.idTaxa = idTaxa;
		this.statusTaxaPagamento = statusTaxaPagamento;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.idCondomino = idCondomino;
		this.nomeCondomino = nomeCondomino;
		this.unidadeCondomino = unidadeCondomino;
	}

	public Integer getIdTaxa() {
		return idTaxa;
	}

	public void setIdTaxa(Integer idTaxa) {
		this.idTaxa = idTaxa;
	}

	public StatusTaxaPagamento getStatusTaxaPagamento() {
		return statusTaxaPagamento;
	}

	public void setStatusTaxaPagamento(StatusTaxaPagamento statusTaxaPagamento) {
		this.statusTaxaPagamento = statusTaxaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Integer getIdCondomino() {
		return idCondomino;
	}

	public void setIdCondomino(Integer idCondomino) {
		this.idCondomino = idCondomino;
	}

	public String getNomeCondomino() {
		return nomeCondomino;
	}

	public void setNomeCondomino(String nomeCondomino) {
		this.nomeCondomino = nomeCondomino;
	}

	public String getUnidadeCondomino() {
		return unidadeCondomino;
	}

	public void setUnidadeCondomino(String unidadeCondomino) {
		this.unidadeCondomino = unidadeCondomino;
	}

}