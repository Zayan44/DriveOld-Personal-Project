package br.com.personalproject.siseventos.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.dto.LoginRequestDTO;

@Service
public class LoginService {

    private final AuthenticationManager authManager;

    public LoginService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public void autenticar(LoginRequestDTO dto) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());
            Authentication authentication = authManager.authenticate(authToken);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }
    }
}
