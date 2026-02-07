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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.ServicoRequestDTO;
import br.com.personalproject.siseventos.dto.ServicoResponseDTO;
import br.com.personalproject.siseventos.service.ServicoService;
import jakarta.validation.Valid;  

@RequestMapping("/api/servico")
@RestController
@CrossOrigin("http://localhost:5173")
public class ServicoController {

    @Autowired
    ServicoService servicoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<ServicoResponseDTO>> listarServico() {
        List<ServicoResponseDTO> response = servicoService.listarServico();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ServicoResponseDTO> cadastrarServico(@Valid @RequestBody ServicoRequestDTO servico) {
        ServicoResponseDTO response = servicoService.cadastrarServico(servico);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getIdServico())
        .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@Valid @RequestBody ServicoRequestDTO servico, @PathVariable Long id) {
         ServicoResponseDTO response = servicoService.atualizarServico(servico,id);
         return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }

}
