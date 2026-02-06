package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.VeiculoRequestDTO;
import br.com.personalproject.siseventos.dto.VeiculoResponseDTO;
import br.com.personalproject.siseventos.entity.Veiculo;

public class VeiculoMapper {

    public static Veiculo toEntity(VeiculoRequestDTO dto) {

        Veiculo entity = new Veiculo();

        entity.setTipo(dto.getTipo());
        entity.setPlaca(dto.getPlaca());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setAno(dto.getAno());

        return entity;
    }

    public static VeiculoResponseDTO toDto(Veiculo entity) {

        VeiculoResponseDTO dto = new VeiculoResponseDTO();

        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo());
        dto.setPlaca(entity.getPlaca());
        dto.setMarca(entity.getMarca());
        dto.setModelo(entity.getModelo());
        dto.setAno(entity.getAno());
        dto.setIdCliente(entity.getCliente().getId());
        
        return dto;
    }

    public static Veiculo toUpdateEntity(VeiculoRequestDTO dto, Veiculo entity) {

        entity.setTipo(dto.getTipo());
        entity.setPlaca(dto.getPlaca());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setAno(dto.getAno());
        
        return entity;
    }
}
