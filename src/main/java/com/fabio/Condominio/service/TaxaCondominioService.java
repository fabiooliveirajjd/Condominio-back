package com.fabio.Condominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Condominio.entidade.TaxaCondominio;
import com.fabio.Condominio.repositories.TaxaCondominioRepository;

@Service
public class TaxaCondominioService {

	@Autowired
	private TaxaCondominioRepository taxaCondominioRepository;
	
	public TaxaCondominio create(TaxaCondominio taxaCondominio) {
		return taxaCondominioRepository.save(taxaCondominio);
	}
	
}
