package br.com.personalproject.siseventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.dto.LoginRequestDTO;

@Service
public class LoginService {

    @Autowired 
    private AuthenticationManager authenticationManager;

    public void autenticar(LoginRequestDTO dto) {        
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getSenha());
    
        Authentication auth = authenticationManager.authenticate(authentication);
        
        SecurityContextHolder.getContext().setAuthentication(auth);
    }


}   
