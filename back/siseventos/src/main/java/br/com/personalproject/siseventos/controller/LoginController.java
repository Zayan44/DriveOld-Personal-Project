package br.com.personalproject.siseventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.personalproject.siseventos.dto.LoginRequestDTO;
import br.com.personalproject.siseventos.service.LoginService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginService loginService;
    
    @PostMapping("/funcionario")
    public ResponseEntity<?> realizarLogin(@Valid @RequestBody LoginRequestDTO dto) {
        loginService.autenticar(dto);
    return ResponseEntity.ok("Autenticado com sucesso");
}

}
