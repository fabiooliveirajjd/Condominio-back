package com.fabio.Condominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.Condominio.entidade.Condomino;

public interface CondominoRepository extends JpaRepository<Condomino, Integer> {

}
