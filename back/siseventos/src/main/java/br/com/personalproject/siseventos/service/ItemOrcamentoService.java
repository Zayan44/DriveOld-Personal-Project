package br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.repository.ItemOrcamentoRepository;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.mapper.ItemOrcamentoMapper;


public class ItemOrcamentoService {

    @Autowired
    ItemOrcamentoRepository itemOrcamentoRepository;
    
    public ResponseEntity<?> criarItemOrcamento(ItemOrcamentoRequestDTO itemOrcamentoRequestDTO) {

        ItemOrcamento itemOrcamentoSalvo = ItemOrcamentoMapper.toEntity(itemOrcamentoRequestDTO);
        
        itemOrcamentoRepository.save(itemOrcamentoSalvo);

        ItemOrcamentoResponseDTO dtoResponse = ItemOrcamentoMapper.toDto(itemOrcamentoSalvo);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(dtoResponse.getId())
        .toUri();

        return ResponseEntity.created(location).body(dtoResponse);
    }

    public ResponseEntity<?> deletarItemOrcamento(Long id) {
        itemOrcamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
