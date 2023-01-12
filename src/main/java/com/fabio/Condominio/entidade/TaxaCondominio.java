package com.fabio.Condominio.entidade;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fabio.Condominio.enuns.StatusTaxaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TaxaCondominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTaxaCondominio;

	private StatusTaxaPagamento statusTaxaPagamento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento = LocalDate.now();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_condominio")
	private Condomino condomino;

	public TaxaCondominio() {
		super();
	}

	public TaxaCondominio(Integer idTaxaCondominio, StatusTaxaPagamento statusTaxaPagamento, Condomino condomino) {
		super();
		this.idTaxaCondominio = idTaxaCondominio;
		this.statusTaxaPagamento = statusTaxaPagamento;
		this.condomino = condomino;
	}

	public Integer getIdTaxaCondominio() {
		return idTaxaCondominio;
	}

	public void setIdTaxaCondominio(Integer idTaxaCondominio) {
		this.idTaxaCondominio = idTaxaCondominio;
	}

	public StatusTaxaPagamento getStatusTaxaPagamento() {
		return statusTaxaPagamento;
	}

	public void setStatusTaxaPagamento(StatusTaxaPagamento statusTaxaPagamento) {
		this.statusTaxaPagamento = statusTaxaPagamento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

}