package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.service.OrcamentoService;

import java.util.List;

import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;

@RestController
@CrossOrigin("http://localhost:5173")
public class OrcamentoController {

    @Autowired
    OrcamentoService orcamentoService;
    
    @GetMapping("/listar/orcamento")

    public ResponseEntity<List<OrcamentoResponseDTO>> listarOrcamento() {

    return ResponseEntity.ok(orcamentoService.listarOrcamento());
    
}
    @PostMapping("/cadastrar/orcamento")
    public ResponseEntity<?> cadastrarOrcamento(@RequestBody Orcamento orcamento, @PathVariable Long idVeiculo) {
        return orcamentoService.cadastrarOrcamento(orcamento,idVeiculo);
    }
    
    @DeleteMapping("/deletar/Orcamento/{id}")
    public ResponseEntity<?> deletarOrcamento(@PathVariable Long id) {
        return orcamentoService.deletarOrcamento(id);
    }

}
