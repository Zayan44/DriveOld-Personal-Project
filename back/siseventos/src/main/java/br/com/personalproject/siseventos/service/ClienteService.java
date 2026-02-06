package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalproject.siseventos.dto.ClienteRequestDTO;
import br.com.personalproject.siseventos.dto.ClienteResponseDTO;
import br.com.personalproject.siseventos.entity.Cliente;
import br.com.personalproject.siseventos.mapper.ClienteMapper;
import br.com.personalproject.siseventos.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> listarCliente() {

        List <Cliente> clientes = clienteRepository.findAll();
        
        List <ClienteResponseDTO> response = clientes
            .stream()
            .map(ClienteMapper::toDto)
            .toList();

        return response;
    }

    @Transactional
    public ClienteResponseDTO cadastrarCliente(ClienteRequestDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        clienteRepository.save(cliente);
        ClienteResponseDTO response = ClienteMapper.toDto(cliente);
        return response;
    }

    @Transactional
    public ClienteResponseDTO atualizarCliente(ClienteRequestDTO dto, Long id) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        cliente.setId(id);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        ClienteResponseDTO response = ClienteMapper.toDto(clienteAtualizado);
        return response;
    }
    
    @Transactional
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}