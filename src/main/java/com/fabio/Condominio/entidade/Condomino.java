package com.fabio.Condominio.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condomino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCondomino;
	private String nome;
	private String contato;
	private String email;
	private String unidade;

}
