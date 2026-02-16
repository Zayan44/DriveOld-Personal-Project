package br.com.personalproject.siseventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.repository.ContaRepository;

@Service
public class ContaDetailsService implements UserDetailsService{  

    @Autowired
    ContaRepository contaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return contaRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Email não encontrado"));
    }
}
