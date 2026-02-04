package br.com.personalproject.siseventos.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.dto.ServicoRequestDTO;
import br.com.personalproject.siseventos.dto.ServicoResponseDTO;
import br.com.personalproject.siseventos.service.ServicoService;  

@RestController
@CrossOrigin("http://localhost:5173")
public class ServicoController {

    @Autowired
    ServicoService servicoService;
    
@GetMapping("/listar/servico")

    public ResponseEntity<List<ServicoResponseDTO>> listarServico() {
    return servicoService.listarServico();
    }

    @PostMapping("/cadastrar/servico")
    public ResponseEntity<ServicoResponseDTO> cadastrarServico(@RequestBody ServicoRequestDTO servico) {
        return servicoService.cadastrarServico(servico);
    }

    @PutMapping("/atualizar/servico/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@RequestBody ServicoRequestDTO servico, @PathVariable Long id) {
        return servicoService.atualizarServico(servico,id);
    }

    @DeleteMapping("/deletar/servico/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        return servicoService.deletarServico(id);
    }

}
