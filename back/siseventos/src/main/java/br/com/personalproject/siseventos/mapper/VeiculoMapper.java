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

    public static VeiculoResponseDTO toDto(Veiculo veiculo) {

        VeiculoResponseDTO dto = new VeiculoResponseDTO();

        dto.setTipo(veiculo.getTipo());
        dto.setPlaca(veiculo.getPlaca());
        dto.setMarca(veiculo.getMarca());
        dto.setModelo(veiculo.getModelo());
        dto.setAno(veiculo.getAno());
        dto.setIdCliente(veiculo.getCliente().getIdPessoa());
        
        return dto;
    }

    public static void toUpdateEntity(VeiculoRequestDTO dto, Veiculo veiculo) {

        veiculo.setTipo(dto.getTipo());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAno(dto.getAno());
    }
}
