package br.com.personalproject.siseventos.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.entity.Conta;
import br.com.personalproject.siseventos.repository.ContaRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ContaRepository contaRepository;

    public CustomUserDetailsService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Conta conta = contaRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("E-mail não encontrado"));

        // Converte a Conta em UserPrincipal
        return new UserPrincipal(conta.getEmail(), conta.getSenha(), conta.getRole().name());
    }
}
