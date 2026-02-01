package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.service.ItemOrcamentoService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/item-orcamento")
@RestController
public class ItemOrcamentoController {

    @Autowired
    ItemOrcamentoService itemOrcamentoService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarItemOrcamento(@RequestBody ItemOrcamentoRequestDTO itemOrcamento) {
        return itemOrcamentoService.criarItemOrcamento(itemOrcamento);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarItemOrcamento(@PathVariable Long id) {
        return itemOrcamentoService.deletarItemOrcamento(id);
    }
}
