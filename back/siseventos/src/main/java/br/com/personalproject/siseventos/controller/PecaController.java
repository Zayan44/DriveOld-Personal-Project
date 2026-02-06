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

import br.com.personalproject.siseventos.dto.PecaRequestDTO;
import br.com.personalproject.siseventos.dto.PecaResponseDTO;
import br.com.personalproject.siseventos.service.PecaService;

@RestController
@RequestMapping("/api/peca")
@CrossOrigin("http://localhost:5173")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    // Listar peças
    @GetMapping("/listar")
    public ResponseEntity<List<PecaResponseDTO>> listarPeca() {
        List<PecaResponseDTO> response = pecaService.listarPeca();
        return ResponseEntity.ok(response);
    }

    // Cadastrar peça
    @PostMapping("/cadastrar")
    public ResponseEntity<PecaResponseDTO> cadastrarPeca(@RequestBody PecaRequestDTO dto) {
        PecaResponseDTO response = pecaService.cadastrarPeca(dto);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getIdPeca())
        .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PecaResponseDTO> atualizarPeca(@RequestBody PecaRequestDTO dto, @PathVariable Long id) {
        PecaResponseDTO response = pecaService.atualizarPeca(dto, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPeca(@PathVariable Long id) {
        pecaService.deletarPeca(id);
        return ResponseEntity.noContent().build();
    }
}
