package com.fabio.Condominio.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.Condominio.entidade.TaxaCondominio;
import com.fabio.Condominio.service.TaxaCondominioService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/taxas")
public class TaxaCondominioController {

	
	@Autowired 
	TaxaCondominioService taxaCondominioService;
	
	@PostMapping
	public ResponseEntity<TaxaCondominio> create(@RequestBody TaxaCondominio taxaCondominio){
		TaxaCondominio novaTaxaCondominio = taxaCondominioService.create(taxaCondominio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novaTaxaCondominio.getIdTaxaCondominio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
