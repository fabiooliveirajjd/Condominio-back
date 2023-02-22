package com.fabio.Condominio.controller;

import java.net.URI;
import java.time.LocalDate;
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
import com.fabio.Condominio.entidade.Taxa;
import com.fabio.Condominio.enuns.StatusTaxaPagamento;
import com.fabio.Condominio.service.CondominoService;
import com.fabio.Condominio.service.TaxaService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/taxas")
public class TaxaController {

	@Autowired
	public TaxaService taxaService;

	@Autowired
	private CondominoService condominoService;

	@PostMapping
	public ResponseEntity<Taxa> create(@RequestBody Taxa taxa) {
		if (taxa.getStatusTaxaPagamento().equals(StatusTaxaPagamento.ABERTO)) {
			taxa.setDataPagamento(null);
		} else if (taxa.getStatusTaxaPagamento().equals(StatusTaxaPagamento.pagoComDesconto)) {
			taxa.setDataPagamento(LocalDate.now());
		} else if (taxa.getStatusTaxaPagamento().equals(StatusTaxaPagamento.pagoSemDesconto)) {
			taxa.setDataPagamento(LocalDate.now());
		}
		Taxa novaTaxaCondominio = taxaService.create(taxa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novaTaxaCondominio.getIdTaxa()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<Taxa>> ListarTodasAsTaxas() {
		List<Taxa> listTaxa = taxaService.ListarTodasAsTaxas();
		for (Taxa taxa : listTaxa) {
			Condomino condomino = condominoService.buscarCondominoPorId(taxa.getIdCondomino());
			taxa.setNomeCondomino(condomino != null ? condomino.getNome() : "Condômino Ecluído");
			taxa.setUnidadeCondomino(condomino != null ? condomino.getUnidade() : "Condômino Ecluído");

		}

		return ResponseEntity.ok().body(listTaxa);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Taxa> buscarPorId(@PathVariable Integer id) {
		Taxa obj = taxaService.buscarPorId(id);
		Condomino condomino = condominoService.buscarCondominoPorId(obj.getIdCondomino());
		obj.setNomeCondomino(condomino != null ? condomino.getNome() : "Condômino Ecluído");
		obj.setUnidadeCondomino(condomino != null ? condomino.getUnidade() : "Condômino Ecluído");

		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Taxa> atualizar(@PathVariable Integer id, @RequestBody Taxa taxa) {
		
		if (taxa.getStatusTaxaPagamento().equals(StatusTaxaPagamento.ABERTO)) {
			taxa.setDataPagamento(null);
		} else if (taxa.getStatusTaxaPagamento().equals(StatusTaxaPagamento.pagoComDesconto)) {
			taxa.setDataPagamento(LocalDate.now());
		} else if (taxa.getStatusTaxaPagamento().equals(StatusTaxaPagamento.pagoSemDesconto)) {
			taxa.setDataPagamento(LocalDate.now());
		}
		Taxa obj = taxaService.atualizar(id, taxa);
		Condomino condomino = condominoService.buscarCondominoPorId(obj.getIdCondomino());
		obj.setNomeCondomino(condomino != null ? condomino.getNome() : "Condômino Ecluído");
		obj.setUnidadeCondomino(condomino != null ? condomino.getUnidade() : "Condômino Ecluído");
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Taxa> excluir(@PathVariable Integer id) {
		taxaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
  
}
