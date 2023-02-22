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

	public Condomino salvarCondomino(Condomino condomino) {
		return condominoRepository.save(condomino);
	}

	public List<Condomino> listarCondominos() {
		return condominoRepository.findAll();
	}

	public Condomino buscarCondominoPorId(Integer id) {
		Optional<Condomino> optionalCondomino = condominoRepository.findById(id);
		return optionalCondomino.orElse(null);
	}

	public Condomino alterarCondomino(Integer id, Condomino condomino) {
		Optional<Condomino> optionalCondomino = condominoRepository.findById(id);
		if (optionalCondomino.isPresent()) {
			condomino.setIdCondomino(id);
			return condominoRepository.save(condomino);
		}
		return null;
	}

	public void excluirCondomino(Integer id) {
		condominoRepository.deleteById(id);
	}

}
