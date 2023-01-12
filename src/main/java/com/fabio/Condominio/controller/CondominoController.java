package com.fabio.Condominio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.Condominio.entidade.Condomino;
import com.fabio.Condominio.service.CondominoService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/condominos")
public class CondominoController {

	@Autowired
	CondominoService condominoService;

	@PostMapping
	public ResponseEntity<Condomino> create(@RequestBody Condomino condomino) {
		Condomino novoCondomino = condominoService.create(condomino);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoCondomino.getIdCondomino()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<Condomino>> ListarTodosCondominos(){
		List<Condomino> listCondominos = condominoService.ListarTodosCondominos();
		return ResponseEntity.ok().body(listCondominos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Condomino> buscarPorId (@PathVariable Integer id){
		Condomino obj = condominoService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Condomino> atualizar(@PathVariable Integer id, @RequestBody Condomino condomino){
		Condomino obj = condominoService.atualizar(id, condomino);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Condomino> excluir(@PathVariable Integer id) {
		condominoService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
