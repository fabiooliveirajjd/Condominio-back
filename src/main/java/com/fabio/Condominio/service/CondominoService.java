package com.fabio.Condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Condominio.entidade.Condomino;
import com.fabio.Condominio.repositories.CondominoRepository;

@Service
public class CondominoService {
	@Autowired
	private CondominoRepository condominoRepository;
	
	public Condomino create(Condomino condomino) {
	return condominoRepository.save(condomino);
	}
	
	public List<Condomino> ListarTodosCondominos(){
		return condominoRepository.findAll();
	}
	
	public Condomino buscarPorId(Integer id) {
		Optional<Condomino> obj = condominoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Condomino atualizar(Integer id, Condomino condomino) {
		Condomino oldObj = buscarPorId(id);
		return condominoRepository.save(condomino);
	}
	
	public void excluir(Integer id){
		Condomino obj = buscarPorId(id);
		condominoRepository.deleteById(id);
	}
	
	
}
