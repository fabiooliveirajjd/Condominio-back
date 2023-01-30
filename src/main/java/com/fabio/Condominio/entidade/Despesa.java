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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Despesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDespesa;

	@Column
	private BigDecimal valorEntrada;

	@Column
	private BigDecimal valorSaida;

	@Column
	private String descriminacao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento;

	@Transient
	private BigDecimal caixaTotal;

	public Despesa() {
		super();
	}

	public Despesa(Integer idDespesa, BigDecimal valorEntrada, BigDecimal valorSaida, String descriminacao,
			LocalDate dataPagamento, BigDecimal caixaTotal) {
		super();
		this.idDespesa = idDespesa;
		this.valorEntrada = valorEntrada;
		this.valorSaida = valorSaida;
		this.descriminacao = descriminacao;
		this.dataPagamento = dataPagamento;
		this.caixaTotal = caixaTotal;
	}

	public Integer getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(Integer idDespesa) {
		this.idDespesa = idDespesa;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public BigDecimal getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(BigDecimal valorSaida) {
		this.valorSaida = valorSaida;
	}

	public String getDescriminacao() {
		return descriminacao;
	}

	public void setDescriminacao(String descriminacao) {
		this.descriminacao = descriminacao;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getCaixaTotal() {
		return caixaTotal;
	}

	public void setCaixaTotal(BigDecimal caixaTotal) {
		this.caixaTotal = caixaTotal;
	}

}
