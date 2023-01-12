package com.fabio.Condominio.controller;

import java.net.URI;
import java.util.Iterator;
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
import com.fabio.Condominio.entidade.TaxaCondominio;
import com.fabio.Condominio.service.CondominoService;
import com.fabio.Condominio.service.TaxaCondominioService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/taxas")
public class TaxaCondominioController {

	
	@Autowired 
	TaxaCondominioService taxaCondominioService;
	
	@Autowired
	private CondominoService condominoService;
	
	@PostMapping
	public ResponseEntity<TaxaCondominio> create(@RequestBody TaxaCondominio taxaCondominio){
		TaxaCondominio novaTaxaCondominio = taxaCondominioService.create(taxaCondominio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novaTaxaCondominio.getIdTaxaCondominio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<TaxaCondominio>>ListarTodasAsTaxas(){
		List<TaxaCondominio> listTaxaCondominio = taxaCondominioService.ListarTodasAsTaxas();	
		
		
		
		return ResponseEntity.ok().body(listTaxaCondominio);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaxaCondominio> buscarPorId (@PathVariable Integer id){
		TaxaCondominio obj = taxaCondominioService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TaxaCondominio> atualizar (@PathVariable Integer id, @RequestBody TaxaCondominio taxaCondominio){
		TaxaCondominio obj = taxaCondominioService.atualizar(id, taxaCondominio);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TaxaCondominio> excluir (@PathVariable Integer id){
		taxaCondominioService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
}
