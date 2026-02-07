package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.ClienteRequestDTO;
import br.com.personalproject.siseventos.dto.ClienteResponseDTO;
import br.com.personalproject.siseventos.entity.Cliente;

public class ClienteMapper {
    
    public static Cliente toEntity(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());
        cliente.setCpf(dto.getCpf());
        cliente.setEstado(dto.getEstado());
        cliente.setCidade(dto.getCidade());
        cliente.setBairro(dto.getBairro());

        return cliente;
    }

    public static ClienteResponseDTO toDto(Cliente entity) {

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        dto.setEndereco(entity.getEndereco());
        dto.setCpf(entity.getCpf());
        dto.setEstado(entity.getEstado());
        dto.setCidade(entity.getCidade());
        dto.setBairro(entity.getBairro());

        if(entity.getVeiculosCadastradoList() != null) {
            dto.setVeiculos(
                entity.getVeiculosCadastradoList()
                .stream()
                .map(VeiculoMapper::toDto)
                .toList()
            );
        }

        return dto;
    }

    public static Cliente toUpdate(Cliente entity,ClienteRequestDTO dto) {

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setEndereco(dto.getEndereco());
        entity.setEstado(dto.getEstado());
        entity.setCidade(dto.getCidade());
        entity.setBairro(dto.getBairro());
        
        return entity;
    }

}
