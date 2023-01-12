package com.fabio.Condominio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fabio.Condominio.entidade.TaxaCondominio;

public interface TaxaCondominioRepository extends JpaRepository<TaxaCondominio, Integer> {

	@Query(value = "select tx.id_taxa_condominio,  tx.data_pagamento,  tx.status_taxa_pagamento,  tx.id_condominio, cd.nome, cd.unidade "
			+ "from taxa_condominio as tx "
			+ "inner join condomino as cd "
			+ "on cd.id_condominio = tx.id_condominio",
	   		nativeQuery = true)
	List<TaxaCondominio> buscarTodosAsTaxas();

}
