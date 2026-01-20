package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.service.PecaService;

@RestController
@CrossOrigin("http://localhost:5173")
public class PecaController {

    @Autowired
    PecaService PecaService;
    
    @GetMapping("/listar/peca")

    public ResponseEntity<Iterable<Peca>> listarPeca() {
    return PecaService.listarPeca();
    }

    @PostMapping("/cadastrar/peca")
    public ResponseEntity<?> cadastrarPeca(@RequestBody Peca Peca) {
        return PecaService.cadastrarPeca(Peca);
    }

    @PutMapping("/atualizar/peca/{id}")
    public ResponseEntity<?> atualizarPeca(@RequestBody Peca Peca, @PathVariable Long id) {
        return PecaService.atualizarPeca(Peca,id);
    }

    @DeleteMapping("/deletar/peca/{id}")
    public ResponseEntity<?> deletarPeca(@PathVariable Long id) {
        return PecaService.deletarPeca(id);
    }

}
