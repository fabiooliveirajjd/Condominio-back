package com.fabio.Condominio.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<TaxaCondominio> ListarTodasAsTaxas (){
		return taxaCondominioRepository.buscarTodosAsTaxas();
	}
	
	public TaxaCondominio buscarPorId (Integer id) {
		Optional<TaxaCondominio> obj = taxaCondominioRepository.findById(id);
		return obj.orElse(null);
	}
	
	public TaxaCondominio atualizar (Integer id, TaxaCondominio taxaCondominio) {
		TaxaCondominio oldObj = buscarPorId(id);
		return taxaCondominioRepository.save(taxaCondominio);
	}
	
	public void excluir (Integer id) {
		TaxaCondominio oldObj = buscarPorId(id);
		taxaCondominioRepository.deleteById(id);
	}
	
}
