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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Taxa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTaxa;

	private StatusTaxaPagamento statusTaxaPagamento;

	private BigDecimal valor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento;

	private Integer idCondomino;

	@Transient
	private String nomeCondomino;

	@Transient
	private String unidadeCondomino;

}