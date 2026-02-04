package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.MecanicoRequestDTO;
import br.com.personalproject.siseventos.dto.MecanicoResponseDTO;
import br.com.personalproject.siseventos.entity.Mecanico;

public class MecanicoMapper {

    public static Mecanico toEntity(MecanicoRequestDTO dto) {
        
        Mecanico entity = new Mecanico();

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setEndereco(dto.getEndereco());
        entity.setCpf(dto.getCpf());
        entity.setEstado(dto.getEstado());
        entity.setCidade(dto.getCidade());
        entity.setBairro(dto.getBairro());

        return entity;
    }

    public static MecanicoResponseDTO toDto(Mecanico entity) {

        MecanicoResponseDTO dto = new MecanicoResponseDTO();

        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        dto.setEndereco(entity.getEndereco());
        dto.setCpf(entity.getCpf());
        dto.setEstado(entity.getEstado());
        dto.setCidade(entity.getCidade());

        return dto;
    }

    public static Mecanico toUpdate(MecanicoRequestDTO dto, Mecanico entity) {

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setEndereco(dto.getEndereco());
        entity.setCpf(dto.getCpf());
        entity.setEstado(dto.getEstado());
        entity.setCidade(dto.getCidade());
        entity.setBairro(dto.getBairro());
        
        return entity;
    }
}
