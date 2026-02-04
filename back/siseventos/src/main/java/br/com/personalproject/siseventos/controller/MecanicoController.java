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

import br.com.personalproject.siseventos.dto.MecanicoRequestDTO;
import br.com.personalproject.siseventos.dto.MecanicoResponseDTO;
import br.com.personalproject.siseventos.service.MecanicoService;

@RestController
@CrossOrigin("http://localhost:5173")
public class MecanicoController {

    @Autowired
    MecanicoService mecanicoService;
    
@GetMapping("/listar/mecanico")

    public ResponseEntity<List<MecanicoResponseDTO>> listarMecanico() {
        return mecanicoService.listarMecanico();
    }

    @PostMapping("/cadastrar/mecanico")
    public ResponseEntity<MecanicoResponseDTO> cadastrarMecanico(@RequestBody MecanicoRequestDTO dto) {
        return mecanicoService.cadastrarMecanico(dto);
    }

    @PutMapping("/atualizar/mecanico/{id}")
    public ResponseEntity<MecanicoResponseDTO> atualizarMecanico(@RequestBody MecanicoRequestDTO dto, @PathVariable Long id) {
        return mecanicoService.atualizarMecanico(dto, id);
    }

    @DeleteMapping("/deletar/mecanico/{id}")
    public ResponseEntity<Void> deletarMecanico(@PathVariable Long id) {
        return mecanicoService.deletarMecanico(id);
    }
}
