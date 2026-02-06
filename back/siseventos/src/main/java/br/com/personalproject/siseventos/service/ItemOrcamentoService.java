package br.com.personalproject.siseventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.mapper.ItemOrcamentoMapper;
import br.com.personalproject.siseventos.repository.ItemOrcamentoRepository;

@Service
public class ItemOrcamentoService {

    @Autowired
    ItemOrcamentoRepository itemOrcamentoRepository;
    
    @Transactional(readOnly = true)
    public ItemOrcamentoResponseDTO criarItemOrcamento(ItemOrcamentoRequestDTO itemOrcamentoRequestDTO) {
        ItemOrcamento itemOrcamentoSalvo = ItemOrcamentoMapper.toEntity(itemOrcamentoRequestDTO);
        itemOrcamentoRepository.save(itemOrcamentoSalvo);
        ItemOrcamentoResponseDTO response = ItemOrcamentoMapper.toDto(itemOrcamentoSalvo);
        return response;
    }

    @Transactional
    public void deletarItemOrcamento(Long id) {
        itemOrcamentoRepository.deleteById(id);
    }

}
