package br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.ClienteResponseDTO;
import br.com.personalproject.siseventos.entity.Cliente;
import br.com.personalproject.siseventos.repository.ClienteRepository;

import br.com.personalproject.siseventos.mapper.ClienteMapper;
import java.util.List; 
import br.com.personalproject.siseventos.dto.ClienteRequestDTO;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    //Metodo para listar clientes
    public ResponseEntity<List<ClienteResponseDTO>> listarCliente() {

        List <Cliente> clientes = clienteRepository.findAll();
        
        List <ClienteResponseDTO> dto = clientes
            .stream()
            .map(ClienteMapper::toDto)
            .toList();

        return ResponseEntity.ok(dto);
}

    //Metodo para cadastrar Clientes
    public ResponseEntity<?> cadastrarCliente(ClienteRequestDTO dto) {
        
        Cliente cliente = ClienteMapper.toEntity(dto);

        clienteRepository.save(cliente);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(cliente.getIdPessoa())
        .toUri();

        return ResponseEntity.created(location).body(dto);
    }

    //Metodo para atualizar Clientes
    public ResponseEntity<?> atualizarCliente(ClienteRequestDTO dto, Long id) {
        
        Cliente cliente = clienteRepository.findById(id).get();

        ClienteMapper.toEntity(dto, cliente);

        Cliente cliente = ClienteMapper.toEntity(dto);
        cliente.setIdPessoa(id);
        Cliente clienteAtualizar = clienteRepository.save(cliente);
        ClienteResponseDTO clienteResponseDTO = ClienteMapper.toDto(clienteAtualizar);

        return ResponseEntity.ok(clienteResponseDTO);
    }

    //Metodo para deletar Clientes
    public ResponseEntity<?> deletarCliente(Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}