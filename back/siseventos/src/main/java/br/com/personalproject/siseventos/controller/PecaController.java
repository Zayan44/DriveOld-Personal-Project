package br.com.personalproject.siseventos.controller;

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

import br.com.personalproject.siseventos.dto.PecaRequestDTO;
import br.com.personalproject.siseventos.dto.PecaResponseDTO;
import br.com.personalproject.siseventos.service.PecaService;

@RestController
@RequestMapping("/pecas")
@CrossOrigin("http://localhost:5173")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    // Listar peças
    @GetMapping
    public ResponseEntity<List<PecaResponseDTO>> listarPeca() {
        return pecaService.listarPeca();
    }

    // Cadastrar peça
    @PostMapping
    public ResponseEntity<PecaResponseDTO> cadastrarPeca(@RequestBody PecaRequestDTO dto) {
        return pecaService.cadastrarPeca(dto);
    }

    // Atualizar peça
    @PutMapping("/{id}")
    public ResponseEntity<PecaResponseDTO> atualizarPeca(
            @RequestBody PecaRequestDTO dto,
            @PathVariable Long id
    ) {
        return pecaService.atualizarPeca(dto, id);
    }

    // Deletar peça
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPeca(@PathVariable Long id) {
        return pecaService.deletarPeca(id);
    }
}
