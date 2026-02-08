package br.com.personalproject.siseventos.mapper;
import br.com.personalproject.siseventos.dto.OrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Veiculo;

public class OrcamentoMapper {

    public static OrcamentoResponseDTO toDto(Orcamento orcamento) {

        OrcamentoResponseDTO dto = new OrcamentoResponseDTO();

        dto.setIdOrcamento(orcamento.getIdOrcamento());
        dto.setIdVeiculo(orcamento.getVeiculo().getId());
        dto.setPlaca(orcamento.getVeiculo().getPlaca());
        dto.setModelo(orcamento.getVeiculo().getModelo());
        dto.setStatus(orcamento.getStatus());
        dto.setValorTotal(orcamento.getValorTotal());

        dto.setDesconto(orcamento.getDesconto());

        return dto;
    }

    public static Orcamento toEntity(OrcamentoRequestDTO dto, Veiculo veiculo) {

        Orcamento orcamento = new Orcamento();
        
        orcamento.setVeiculo(veiculo);
        orcamento.setStatus(dto.getStatus());
        orcamento.setDesconto(dto.getDesconto());
        return orcamento;
    }
}