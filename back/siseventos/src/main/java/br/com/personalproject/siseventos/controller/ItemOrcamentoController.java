package br.com.personalproject.siseventos.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.service.ItemOrcamentoService;
import jakarta.validation.Valid;

@RequestMapping("/api/item")
@RestController
public class ItemOrcamentoController {

    @Autowired
    ItemOrcamentoService itemOrcamentoService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<ItemOrcamentoResponseDTO> cadastrarItemOrcamento(@Valid @RequestBody ItemOrcamentoRequestDTO dto) {
        ItemOrcamentoResponseDTO response = itemOrcamentoService.criarItemOrcamento(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarItemOrcamento(@PathVariable Long id) {
        itemOrcamentoService.deletarItemOrcamento(id);
        return ResponseEntity.noContent().build();
    }
}
