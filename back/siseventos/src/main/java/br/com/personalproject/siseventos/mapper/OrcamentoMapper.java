package br.com.personalproject.siseventos.mapper;
import br.com.personalproject.siseventos.dto.OrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Mecanico;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Veiculo;

public class OrcamentoMapper {

    public static OrcamentoResponseDTO toDto(Orcamento entity) {

        OrcamentoResponseDTO dto = new OrcamentoResponseDTO();

        dto.setId(entity.getId());
        dto.setIdVeiculo(entity.getVeiculo().getId());
        dto.setNomeMecanico(entity.getMecanico().getNome());
        dto.setPlaca(entity.getVeiculo().getPlaca());
        dto.setModelo(entity.getVeiculo().getModelo());
        dto.setStatus(entity.getStatus());
        dto.setValorTotal(entity.getValorTotal());

        dto.setItensOrcamento(
            entity.getItensOrcamento()
            .stream()
            .map(ItemOrcamentoMapper::toDto)
            .toList()
        );

        return dto;
    }

    public static Orcamento toEntity(OrcamentoRequestDTO dto, Veiculo veiculo,Mecanico mecanico) {

        Orcamento entity = new Orcamento();
        
        entity.setMecanico(mecanico);
        entity.setVeiculo(veiculo);
        entity.setStatus(dto.getStatus());
        return entity;
    }
}