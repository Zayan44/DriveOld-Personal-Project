package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.ServicoRequestDTO;
import br.com.personalproject.siseventos.dto.ServicoResponseDTO;
import br.com.personalproject.siseventos.entity.Servico;

public class ServicoMapper {

    public static Servico toEntity(ServicoRequestDTO dto) {

        Servico entity = new Servico();

        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());

        return entity;
    }

    public static ServicoResponseDTO toDto(Servico entity) {
        ServicoResponseDTO dto = new ServicoResponseDTO();
        dto.setIdServico(entity.getIdServico());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setPreco(entity.getPreco());
        return dto;
    }

    public static Servico toUpdate(Servico entity, ServicoRequestDTO dto) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());

        return entity;
    } 
}
