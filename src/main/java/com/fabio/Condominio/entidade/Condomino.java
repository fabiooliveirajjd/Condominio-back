package com.fabio.Condominio.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Condomino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_condominio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCondomino;

	@Column
	private String nome;

	@Column
	private String contato;

	@Column
	private String email;

	@Column
	private String unidade;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_taxa_condominio")
//	private TaxaCondominio taxaCondominio;
	
	public Condomino() {
		super();
	}
	
	

	public Condomino(Integer idCondomino, String nome, String contato, String email, String unidade) {
		super();
		this.idCondomino = idCondomino;
		this.nome = nome;
		this.contato = contato;
		this.email = email;
		this.unidade = unidade;
	}



	public Integer getIdCondomino() {
		return idCondomino;
	}

	public void setIdCondomino(Integer idCondomino) {
		this.idCondomino = idCondomino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	

}
