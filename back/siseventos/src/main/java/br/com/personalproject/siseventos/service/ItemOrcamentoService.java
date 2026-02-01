package br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.repository.ItemOrcamentoRepository;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.mapper.MapperItemOrcamento;


public class ItemOrcamentoService {

    @Autowired
    ItemOrcamentoRepository itemOrcamentoRepository;
    
    public ResponseEntity<?> criarItemOrcamento(ItemOrcamentoRequestDTO itemOrcamentoRequestDTO) {

        ItemOrcamento itemOrcamentoSalvo = MapperItemOrcamento.toEntity(itemOrcamentoRequestDTO);
        
        itemOrcamentoRepository.save(itemOrcamentoSalvo);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(itemOrcamentoSalvo.getIdItemOrcamento())
        .toUri();

        return ResponseEntity.created(location).body(itemOrcamentoSalvo);
    }

    public ResponseEntity<?> deletarItemOrcamento(Long id) {
        itemOrcamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
