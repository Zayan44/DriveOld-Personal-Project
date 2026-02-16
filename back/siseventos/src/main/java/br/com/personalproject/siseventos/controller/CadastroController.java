package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.dto.CadastroRequestDTO;
import br.com.personalproject.siseventos.service.CadastroService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/cadastro")
public class CadastroController {

    @Autowired
    CadastroService cadastroService;

    @PostMapping("/funcionario")
    public ResponseEntity<?> realizarCadastro(@RequestBody CadastroRequestDTO dto) {
        
        cadastroService.validarCadastro(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
