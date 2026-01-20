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

import br.com.personalproject.siseventos.entity.Veiculo;
import br.com.personalproject.siseventos.service.VeiculoService;

@RestController
@CrossOrigin("http://localhost:5173")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;
    
@GetMapping("/listar/Veiculo")

    public ResponseEntity<Iterable<Veiculo>> listarVeiculo() {
    return veiculoService.listarVeiculo();
    }

    @PostMapping("/cadastrar/Veiculo")
    public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long idCliente) {
        return veiculoService.cadastrarVeiculo(veiculo,idCliente);
    }

    @PutMapping("/atualizar/Veiculo/{id}")
    public ResponseEntity<?> atualizarVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long id) {
        return veiculoService.atualizarVeiculo(veiculo,id);
    }

    @DeleteMapping("/deletar/Veiculo/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Long id) {
        return veiculoService.deletarVeiculo(id);
    }

}
