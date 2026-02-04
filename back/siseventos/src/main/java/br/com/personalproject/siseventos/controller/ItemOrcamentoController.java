package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.service.ItemOrcamentoService;

@RequestMapping("/item-orcamento")
@RestController
public class ItemOrcamentoController {

    @Autowired
    ItemOrcamentoService itemOrcamentoService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<ItemOrcamentoResponseDTO> cadastrarItemOrcamento(@RequestBody ItemOrcamentoRequestDTO dto) {
        return itemOrcamentoService.criarItemOrcamento(dto);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarItemOrcamento(@PathVariable Long id) {
        return itemOrcamentoService.deletarItemOrcamento(id);
    }
}
