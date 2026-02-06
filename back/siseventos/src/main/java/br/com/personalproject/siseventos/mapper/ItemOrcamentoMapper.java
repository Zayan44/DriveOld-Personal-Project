package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;
import br.com.personalproject.siseventos.service.PecaService;
import br.com.personalproject.siseventos.service.ServicoService;

public class ItemOrcamentoMapper {

    public static ItemOrcamento toEntity(ItemOrcamentoRequestDTO itemOrcamentoRequestDTO) {

        ItemOrcamento itemOrcamento = new ItemOrcamento();
        PecaService pecaService = new PecaService();
        ServicoService servicoService = new ServicoService();

        if (itemOrcamentoRequestDTO.getTipo().equals(TipoItemOrcamento.SERVICO)) {
            
            Servico servico = servicoService.buscarServicoPorId(itemOrcamentoRequestDTO.getIdReferencia());

            itemOrcamento.setServico(servico);
            itemOrcamento.setTipo(itemOrcamentoRequestDTO.getTipo());  
            itemOrcamento.setQuantidade(itemOrcamentoRequestDTO.getQuantidade());
        }

        else {
            itemOrcamento.setPeca(pecaService.buscarPecaPorId(itemOrcamentoRequestDTO.getIdReferencia()));
            itemOrcamento.setTipo(itemOrcamentoRequestDTO.getTipo());  
            itemOrcamento.setQuantidade(itemOrcamentoRequestDTO.getQuantidade());
        }
     
        return itemOrcamento;
    }

    public static ItemOrcamentoResponseDTO toDto(ItemOrcamento itemOrcamento) {

        ItemOrcamentoResponseDTO itemOrcamentoResponseDTO = new ItemOrcamentoResponseDTO();

        if (itemOrcamento.getTipo().equals(TipoItemOrcamento.SERVICO)) {
            itemOrcamentoResponseDTO.setIdReferencia(itemOrcamento.getServico().getId());
        } 
        
        else {
            itemOrcamentoResponseDTO.setIdReferencia(itemOrcamento.getPeca().getId());
        }

        itemOrcamentoResponseDTO.setId(itemOrcamento.getIdItemOrcamento());
        itemOrcamentoResponseDTO.setQuantidade(itemOrcamento.getQuantidade());
        itemOrcamentoResponseDTO.setValorUnitario(itemOrcamento.getValorUnitario());
        itemOrcamentoResponseDTO.setValorTotal(itemOrcamento.getValorTotal());

        return itemOrcamentoResponseDTO;
    }
}
