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

import br.com.personalproject.siseventos.entity.Mecanico;
import br.com.personalproject.siseventos.service.MecanicoService;

@RestController
@CrossOrigin("http://localhost:5173")
public class MecanicoController {

    @Autowired
    MecanicoService mecanicoService;
    
@GetMapping("/listar/mecanico")

    public ResponseEntity<Iterable<Mecanico>> listarMecanico() {
    return mecanicoService.listarMecanico();
    }

    @PostMapping("/cadastrar/mecanico")
    public ResponseEntity<?> cadastrarMecanico(@RequestBody Mecanico mecanico) {
        return mecanicoService.cadastrarMecanico(mecanico);
    }

    @PutMapping("/atualizar/mecanico/{id}")
    public ResponseEntity<?> atualizarMecanico(@RequestBody Mecanico mecanico, @PathVariable Long id) {
        return mecanicoService.atualizarMecanico(mecanico,id);
    }

    @DeleteMapping("/deletar/mecanico/{id}")
    public ResponseEntity<?> deletarMecanico(@PathVariable Long id) {
        return mecanicoService.deletarMecanico(id);
    }

}
