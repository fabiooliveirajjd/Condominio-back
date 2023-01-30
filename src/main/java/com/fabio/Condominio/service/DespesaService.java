package com.fabio.Condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Condominio.entidade.Despesa;
import com.fabio.Condominio.repositories.DespesaRespository;

@Service
public class DespesaService {

	@Autowired 
	private DespesaRespository despesaRespository;
	
	public List<Despesa> listarTodasAsDespesas(){
		return despesaRespository.findAll();
	}
	
	public Despesa buscarPorId(Integer id) {
		Optional<Despesa> obj = despesaRespository.findById(id);
		return obj.orElse(null);
	}
	
	public Despesa criarDespesa(Despesa despesa) {
		return despesaRespository.save(despesa);
	}
	
	public Despesa atualizarDespesa(Integer id, Despesa despesa) {
		Despesa d = buscarPorId(id);
		return despesaRespository.save(despesa);
	}
	
	public void deletarDespesa (Integer id) {
		Despesa despesa = buscarPorId(id);
		despesaRespository.deleteById(id);
	}
}
