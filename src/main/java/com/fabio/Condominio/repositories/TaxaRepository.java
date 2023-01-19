package com.fabio.Condominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.Condominio.entidade.Taxa;

public interface TaxaRepository extends JpaRepository<Taxa, Integer> {

}
