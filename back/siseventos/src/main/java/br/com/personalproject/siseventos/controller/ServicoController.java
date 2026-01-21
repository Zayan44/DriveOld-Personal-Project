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

import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.service.ServicoService;

@RestController
@CrossOrigin("http://localhost:5173")
public class ServicoController {

    @Autowired
    ServicoService servicoService;
    
@GetMapping("/listar/servico")

    public ResponseEntity<Iterable<Servico>> listarServico() {
    return servicoService.listarServico();
    }

    @PostMapping("/cadastrar/servico")
    public ResponseEntity<?> cadastrarServico(@RequestBody Servico servico) {
        return servicoService.cadastrarServico(servico);
    }

    @PutMapping("/atualizar/servico/{id}")
    public ResponseEntity<?> atualizarServico(@RequestBody Servico servico, @PathVariable Long id) {
        return servicoService.atualizarServico(servico,id);
    }

    @DeleteMapping("/deletar/servico/{id}")
    public ResponseEntity<?> deletarServico(@PathVariable Long id) {
        return servicoService.deletarServico(id);
    }

}
