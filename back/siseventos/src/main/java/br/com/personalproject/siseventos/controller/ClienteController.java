package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.service.ClienteService;
import br.com.personalproject.siseventos.dto.ClienteResponseDTO;

import java.util.List;

import br.com.personalproject.siseventos.dto.ClienteRequestDTO;

@RestController
@CrossOrigin("http://localhost:5173")
public class ClienteController {

@Autowired
ClienteService clienteService;
    
@GetMapping("/listar/cliente")

    public ResponseEntity<List<ClienteResponseDTO>> listarCliente() {
    return clienteService.listarCliente();
    }

    @PostMapping("/cadastrar/cliente")
    public ResponseEntity<?> cadastrarCliente(@RequestBody ClienteRequestDTO dto) {
        return clienteService.cadastrarCliente(dto);
    }

    @PutMapping("/atualizar/cliente/{id}")
    public ResponseEntity<?> atualizarCliente(@RequestBody ClienteRequestDTO dto, @PathVariable Long id) {
        return clienteService.atualizarCliente(dto, id);
    }

    @DeleteMapping("/deletar/cliente/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        return clienteService.deletarCliente(id);
    }

}
