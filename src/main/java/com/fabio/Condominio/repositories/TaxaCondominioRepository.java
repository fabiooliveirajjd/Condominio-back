package com.fabio.Condominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.Condominio.entidade.TaxaCondominio;

public interface TaxaCondominioRepository extends JpaRepository<TaxaCondominio, Integer> {

}
