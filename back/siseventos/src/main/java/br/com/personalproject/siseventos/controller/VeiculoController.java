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

import br.com.personalproject.siseventos.dto.VeiculoRequestDTO;
import br.com.personalproject.siseventos.dto.VeiculoResponseDTO;
import br.com.personalproject.siseventos.service.VeiculoService;

@RequestMapping("/api/veiculo")
@RestController
@CrossOrigin("http://localhost:5173")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculo() {
        List<VeiculoResponseDTO> response = veiculoService.listarVeiculo();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<VeiculoResponseDTO> cadastrarVeiculo(@RequestBody VeiculoRequestDTO dto, @PathVariable Long id) {
        
        VeiculoResponseDTO response = veiculoService.cadastrarVeiculo(dto,id);
       
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarVeiculo(@RequestBody VeiculoRequestDTO veiculo, @PathVariable Long id) {
         VeiculoResponseDTO response = veiculoService.atualizarVeiculo(veiculo,id);
         return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }

}
