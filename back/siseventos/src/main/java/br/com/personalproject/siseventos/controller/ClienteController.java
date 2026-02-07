package br.com.personalproject.siseventos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.ClienteRequestDTO;
import br.com.personalproject.siseventos.dto.ClienteResponseDTO;
import br.com.personalproject.siseventos.service.ClienteService;
import jakarta.validation.Valid;

@RequestMapping("/api/cliente")
@RestController
@CrossOrigin("http://localhost:5173")
public class ClienteController {

@Autowired
ClienteService clienteService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponseDTO>> listarCliente() {
    List<ClienteResponseDTO> response = clienteService.listarCliente();
    return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteRequestDTO dto) {
        
        ClienteResponseDTO response = clienteService.cadastrarCliente(dto);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getId())
        .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@Valid @RequestBody ClienteRequestDTO dto, @PathVariable Long id) {
         ClienteResponseDTO response = clienteService.atualizarCliente(dto, id);
         return ResponseEntity.ok(response);
    }   

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ClienteResponseDTO> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
