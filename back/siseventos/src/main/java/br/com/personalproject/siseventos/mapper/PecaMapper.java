package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.PecaRequestDTO;
import br.com.personalproject.siseventos.dto.PecaResponseDTO;
import br.com.personalproject.siseventos.entity.Peca;

public class PecaMapper {

    public static Peca toEntity(PecaRequestDTO dto) {
        Peca peca = new Peca();
        peca.setNome(dto.getNome());
        peca.setDescricao(dto.getDescricao());
        peca.setFabricante(dto.getFabricante());
        peca.setPreco(dto.getPreco());
        peca.setQuantidade(dto.getQuantidade());
        peca.setQuantidade(dto.getQuantidade());
        return peca;
    }

    public static PecaResponseDTO toDto(Peca peca) {
        PecaResponseDTO dto = new PecaResponseDTO();
        dto.setIdPeca(peca.getId());
        dto.setNome(peca.getNome());
        dto.setDescricao(peca.getDescricao());
        dto.setFabricante(peca.getFabricante());
        dto.setPreco(peca.getPreco());
        dto.setQuantidadeEstoque(peca.getQuantidade());
        return dto;
    }

    public static Peca toUpdate(Peca entity, PecaRequestDTO dto) {
        entity.setNome(dto.getNome());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        return entity;
    }
}

