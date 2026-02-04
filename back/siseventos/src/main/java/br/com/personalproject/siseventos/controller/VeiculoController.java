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

import br.com.personalproject.siseventos.dto.VeiculoRequestDTO;
import br.com.personalproject.siseventos.dto.VeiculoResponseDTO;
import br.com.personalproject.siseventos.service.VeiculoService;

@RestController
@CrossOrigin("http://localhost:5173")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;
    
@GetMapping("/listar/Veiculo")

    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculo() {
    return veiculoService.listarVeiculo();
    }

    @PostMapping("/cadastrar/Veiculo")
    public ResponseEntity<VeiculoResponseDTO> cadastrarVeiculo(@RequestBody VeiculoRequestDTO dto, @PathVariable Long idCliente) {
        return veiculoService.cadastrarVeiculo(dto,idCliente);
    }

    @PutMapping("/atualizar/Veiculo/{id}")
    public ResponseEntity<?> atualizarVeiculo(@RequestBody VeiculoRequestDTO veiculo, @PathVariable Long id) {
        return veiculoService.atualizarVeiculo(veiculo,id);
    }

    @DeleteMapping("/deletar/Veiculo/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        return veiculoService.deletarVeiculo(id);
    }

}
