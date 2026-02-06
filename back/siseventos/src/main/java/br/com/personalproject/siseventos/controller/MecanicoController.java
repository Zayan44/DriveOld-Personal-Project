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

import br.com.personalproject.siseventos.dto.MecanicoRequestDTO;
import br.com.personalproject.siseventos.dto.MecanicoResponseDTO;
import br.com.personalproject.siseventos.service.MecanicoService;

@RequestMapping("/api/mecanico")
@RestController
@CrossOrigin("http://localhost:5173")
public class MecanicoController {

    @Autowired
    MecanicoService mecanicoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<MecanicoResponseDTO>> listarMecanico() {
        List<MecanicoResponseDTO> response = mecanicoService.listarMecanico();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MecanicoResponseDTO> cadastrarMecanico(@RequestBody MecanicoRequestDTO dto) {
        
        MecanicoResponseDTO response = mecanicoService.cadastrarMecanico(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MecanicoResponseDTO> atualizarMecanico(@RequestBody MecanicoRequestDTO dto, @PathVariable Long id) {
        MecanicoResponseDTO response = mecanicoService.atualizarMecanico(dto, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarMecanico(@PathVariable Long id) {
        mecanicoService.deletarMecanico(id);
        return ResponseEntity.noContent().build();
    }
}
