package com.fabio.Condominio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

import com.fabio.Condominio.entidade.Despesa;
import com.fabio.Condominio.service.DespesaService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/despesas")
public class DespesaController {

	@Autowired
	private DespesaService despesaService;

	BigDecimal caixaTotal = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);

	@GetMapping
	public ResponseEntity<List<Despesa>> listarTodasAsDespesas() {
		List<Despesa> listaDespesa = despesaService.listarTodasAsDespesas();
		for (Despesa item : listaDespesa) {

			if (item.getValorEntrada() != null)
				caixaTotal = caixaTotal.add(item.getValorEntrada());
			if (item.getValorSaida() != null)
				caixaTotal = caixaTotal.subtract(item.getValorSaida());

			item.setCaixaTotal(caixaTotal);
		}
		return ResponseEntity.ok().body(listaDespesa);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Despesa> buscarPorId(@PathVariable Integer id) {
		Despesa listaDespesa = despesaService.buscarPorId(id);
		return ResponseEntity.ok().body(listaDespesa);
	}

	@PostMapping
	public ResponseEntity<Despesa> criarDespesa(@RequestBody Despesa despesa) {
		Despesa novaDespesa = despesaService.criarDespesa(despesa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novaDespesa.getIdDespesa()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Despesa> atualizarDespesa(@PathVariable Integer id, @RequestBody Despesa despesa) {
		Despesa des = despesaService.atualizarDespesa(id, despesa);
		return ResponseEntity.ok().body(des);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Despesa> deletarDespesa(@PathVariable Integer id) {
		despesaService.deletarDespesa(id);
		return ResponseEntity.ok().build();
	}

}
