package br.com.personalproject.siseventos.mapper;
import br.com.personalproject.siseventos.dto.OrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Veiculo;

public class OrcamentoMapper {

    public static OrcamentoResponseDTO toDto(Orcamento entity) {

        OrcamentoResponseDTO dto = new OrcamentoResponseDTO();

        dto.setIdOrcamento(entity.getIdOrcamento());
        dto.setIdVeiculo(entity.getVeiculo().getId());
        dto.setPlaca(entity.getVeiculo().getPlaca());
        dto.setModelo(entity.getVeiculo().getModelo());
        dto.setStatus(entity.getStatus());
        dto.setValorTotal(entity.getValorTotal());

        dto.setDesconto(entity.getDesconto());

        dto.setItensOrcamento(
            entity.getItensOrcamento()
            .stream()
            .map(ItemOrcamentoMapper::toDto)
            .toList()
        );

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