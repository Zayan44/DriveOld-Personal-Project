package br.com.personalproject.siseventos.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.dto.CadastroRequestDTO;
import br.com.personalproject.siseventos.entity.Conta;
import br.com.personalproject.siseventos.mapper.ContaMapper;
import br.com.personalproject.siseventos.repository.ContaRepository;

@Service
public class CadastroService {

    private final ContaRepository contaRepository;
    private final PasswordEncoder passwordEncoder;

    public CadastroService(ContaRepository contaRepository, PasswordEncoder passwordEncoder) {
        this.contaRepository = contaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Conta validarCadastro(CadastroRequestDTO dto) {

        contaRepository.findByEmail(dto.getEmail()).ifPresent(u -> {
                throw new RuntimeException("E-mail já cadastrado");
        });

        Conta novaConta = ContaMapper.toEntityCadastro(dto, passwordEncoder);

        return contaRepository.save(novaConta);
    }
}
