package br.com.personalproject.siseventos.mapper;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;

import br.com.personalproject.siseventos.entity.Orcamento;

import java.util.ArrayList;
import java.util.List;


public class MapperOrcamento {

    public static OrcamentoResponseDTO enviarDTO(Orcamento orcamento) {

        OrcamentoResponseDTO orcamentoResponseDTO = new OrcamentoResponseDTO();


        orcamentoResponseDTO.setIdOrcamento(orcamento.getIdOrcamento());
        orcamentoResponseDTO.setIdVeiculo(orcamento.getVeiculo().getIdVeiculo());
        orcamentoResponseDTO.setPlaca(orcamento.getVeiculo().getPlaca());
        orcamentoResponseDTO.setModelo(orcamento.getVeiculo().getModelo());
        orcamentoResponseDTO.setStatus(orcamento.getStatus());
        orcamentoResponseDTO.setValorTotal(orcamento.getValorTotal());
        orcamentoResponseDTO.setValorServico(orcamento.getValorServico());
        orcamentoResponseDTO.setValorPeca(orcamento.getValorPeca());
        orcamentoResponseDTO.setDesconto(orcamento.getDesconto());

        //pendente, verificar erro provavelmente retorno nao esperado
        orcamentoResponseDTO.setItensOrcamento(orcamento.getItensOrcamento()
                .stream()
                .map(MapperItemOrcamento::enviarDTO)
                .toList());


        return orcamentoResponseDTO;
    }
}