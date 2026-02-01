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
        cliente.setSenha(dto.getSenha());
        cliente.setBairro(dto.getBairro());

        return cliente;
    }

    public static ClienteResponseDTO toDto(Cliente cliente) {

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        dto.setEndereco(cliente.getEndereco());
        dto.setCpf(cliente.getCpf());
        dto.setEstado(cliente.getEstado());
        dto.setCidade(cliente.getCidade());

        return dto;
    }


}
