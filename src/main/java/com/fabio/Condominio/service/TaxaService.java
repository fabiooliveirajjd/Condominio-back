package com.fabio.Condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Condominio.entidade.Taxa;
import com.fabio.Condominio.repositories.TaxaRepository;

@Service
public class TaxaService {

	@Autowired
	private TaxaRepository taxaRepository;

	public Taxa create(Taxa taxa) {
		return taxaRepository.save(taxa);
	}

	public List<Taxa> ListarTodasAsTaxas() {
		return taxaRepository.findAll();
	}

	public Taxa buscarPorId(Integer id) {
		Optional<Taxa> obj = taxaRepository.findById(id);
		return obj.orElse(null);
	}

	public Taxa atualizar(Integer id, Taxa taxa) {
		Taxa oldObj = buscarPorId(id);
		return taxaRepository.save(taxa);
	}

	public void excluir(Integer id) {
		Taxa oldObj = buscarPorId(id);
		taxaRepository.deleteById(id);
	}
}
