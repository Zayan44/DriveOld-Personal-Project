package br.com.personalproject.siseventos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.OrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.service.OrcamentoService;

@RequestMapping("/api/orcamento")
@RestController
@CrossOrigin("http://localhost:5173")
public class OrcamentoController {

    @Autowired
    OrcamentoService orcamentoService;

    @GetMapping("/listar")
        public ResponseEntity<List<OrcamentoResponseDTO>> listarOrcamento() {
        return ResponseEntity.ok(orcamentoService.listarOrcamento());
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<OrcamentoResponseDTO> cadastrarOrcamento(@RequestBody OrcamentoRequestDTO orcamento, @PathVariable Long id) {
        
        OrcamentoResponseDTO response = orcamentoService.criarOrcamento(orcamento, id);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getIdOrcamento())
        .toUri();
        
        return ResponseEntity.created(location).body(response);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarOrcamento(@PathVariable Long id) {
        orcamentoService.deletarOrcamento(id);
        return ResponseEntity.noContent().build();
    }
}
