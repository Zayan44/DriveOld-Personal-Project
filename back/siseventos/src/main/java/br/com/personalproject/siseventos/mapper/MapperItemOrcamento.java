package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;


public class MapperItemOrcamento {

    public static ItemOrcamento toEntity(ItemOrcamentoRequestDTO itemOrcamentoRequestDTO) {

        ItemOrcamento itemOrcamento = new ItemOrcamento();

        itemOrcamento.setIdReferencia(itemOrcamentoRequestDTO.getIdReferencia());
        itemOrcamento.setTipo(itemOrcamentoRequestDTO.getTipo());  
        itemOrcamento.setQuantidade(itemOrcamentoRequestDTO.getQuantidade());

        return itemOrcamento;
    }

    public static ItemOrcamentoResponseDTO toDto(ItemOrcamento itemOrcamento) {

        ItemOrcamentoResponseDTO itemOrcamentoResponseDTO = new ItemOrcamentoResponseDTO();

        itemOrcamentoResponseDTO.setId(itemOrcamento.getId());
        itemOrcamentoResponseDTO.setIdReferencia(itemOrcamento.getIdReferencia());
        itemOrcamentoResponseDTO.setTipo(itemOrcamento.getTipo());
        itemOrcamentoResponseDTO.setQuantidade(itemOrcamento.getQuantidade());
        itemOrcamentoResponseDTO.setValorUnitario(itemOrcamento.getValorUnitario());
        itemOrcamentoResponseDTO.setValorTotal(itemOrcamento.getValorTotal());

        return itemOrcamentoResponseDTO;
    }




}
