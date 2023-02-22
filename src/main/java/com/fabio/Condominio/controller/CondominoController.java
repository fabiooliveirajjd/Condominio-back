package com.fabio.Condominio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.Condominio.entidade.Condomino;
import com.fabio.Condominio.service.CondominoService;

@RestController
@RequestMapping("/condominos")
@CrossOrigin(value = "*")
public class CondominoController {

    @Autowired
    private CondominoService condominoService;

    @GetMapping
    public ResponseEntity<List<Condomino>> listarCondominos() {
        List<Condomino> condominos = condominoService.listarCondominos();
        if (condominos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(condominos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condomino> buscarCondominoPorId(@PathVariable Integer id) {
        Condomino condomino = condominoService.buscarCondominoPorId(id);
        if (condomino != null) {
            return ResponseEntity.ok().body(condomino);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Condomino> salvarCondomino(@Validated @RequestBody Condomino condomino) {
        condomino = condominoService.salvarCondomino(condomino);
        URI location = URI.create("/condominos/" + condomino.getIdCondomino());
        return ResponseEntity.created(location).body(condomino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condomino> alterarCondomino(@PathVariable Integer id, @Validated @RequestBody Condomino condomino) {
        condomino = condominoService.alterarCondomino(id, condomino);
        if (condomino != null) {
            return ResponseEntity.ok().body(condomino);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCondomino(@PathVariable Integer id) {
        condominoService.excluirCondomino(id);
        return ResponseEntity.noContent().build();
    }

}
