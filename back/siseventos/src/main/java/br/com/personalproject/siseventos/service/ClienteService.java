package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.ClienteRequestDTO;
import br.com.personalproject.siseventos.dto.ClienteResponseDTO;
import br.com.personalproject.siseventos.entity.Cliente;
import br.com.personalproject.siseventos.mapper.ClienteMapper;
import br.com.personalproject.siseventos.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    //Metodo para listar clientes
    @Transactional(readOnly = true)
    public ResponseEntity<List<ClienteResponseDTO>> listarCliente() {

        List <Cliente> clientes = clienteRepository.findAll();
        
        List <ClienteResponseDTO> dto = clientes
            .stream()
            .map(ClienteMapper::toDto)
            .toList();

        return ResponseEntity.ok(dto);
}

    //Metodo para cadastrar Clientes
    @Transactional
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(ClienteRequestDTO dto) {
        
        Cliente cliente = ClienteMapper.toEntity(dto);

        clienteRepository.save(cliente);

        ClienteResponseDTO clienteResposta = ClienteMapper.toDto(cliente);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(cliente.getIdPessoa())
        .toUri();

        return ResponseEntity.created(location).body(clienteResposta);
    }

    //Metodo para atualizar Clientes
    @Transactional
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(ClienteRequestDTO dto, Long id) {

    Cliente cliente = ClienteMapper.toEntity(dto);

    cliente.setIdPessoa(id);

    Cliente clienteAtualizado = clienteRepository.save(cliente);

    ClienteResponseDTO dtoResponse = ClienteMapper.toDto(clienteAtualizado);

    return ResponseEntity.ok(dtoResponse);
    }
    
    //Metodo para deletar Clientes
    @Transactional
    public ResponseEntity<ClienteResponseDTO> deletarCliente(Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}