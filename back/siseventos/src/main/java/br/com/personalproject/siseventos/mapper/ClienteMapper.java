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

        return dto;
    }

    public static Cliente toUpdate(ClienteRequestDTO dto, Cliente clienteExistente) {

        clienteExistente.setNome(dto.getNome());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setTelefone(dto.getTelefone());
        clienteExistente.setEndereco(dto.getEndereco());
        clienteExistente.setCpf(dto.getCpf());
        clienteExistente.setEstado(dto.getEstado());
        clienteExistente.setCidade(dto.getCidade());
        clienteExistente.setSenha(dto.getSenha());
        clienteExistente.setBairro(dto.getBairro());
        
        return clienteExistente;
    }


}
