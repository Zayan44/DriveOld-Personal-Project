package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;

public class ItemOrcamentoMapper {

    public static ItemOrcamento toEntity(ItemOrcamentoRequestDTO dto,Servico servico,Peca peca) {

        ItemOrcamento item = new ItemOrcamento();

        item.setTipo(dto.getTipo());
        item.setQuantidade(dto.getQuantidade());

        if (dto.getTipo().equals(TipoItemOrcamento.SERVICO)) {
            item.setServico(servico);
        } else {
            item.setPeca(peca);
        }

        return item;
    }

    public static ItemOrcamentoResponseDTO toDto(ItemOrcamento item) {

        ItemOrcamentoResponseDTO dto = new ItemOrcamentoResponseDTO();

        dto.setId(item.getId());
        dto.setQuantidade(item.getQuantidade());
        dto.setValorUnitario(item.getValorUnitario());
        dto.setValorTotal(item.getValorTotal());
        dto.setTipo(item.getTipo());
        
        if (item.getTipo().equals(TipoItemOrcamento.SERVICO)) {
            dto.setIdReferencia(item.getServico().getId());
            dto.setNomeReferencia(item.getServico().getNome());
        } else {
            dto.setIdReferencia(item.getPeca().getId());
            dto.setNomeReferencia(item.getPeca().getNome());
        }

        return dto;
    }
}
