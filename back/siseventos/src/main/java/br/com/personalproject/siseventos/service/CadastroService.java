package br.com.personalproject.siseventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.dto.CadastroRequestDTO;
import br.com.personalproject.siseventos.entity.Conta;
import br.com.personalproject.siseventos.mapper.ContaMapper;
import br.com.personalproject.siseventos.repository.ContaRepository;

@Service
public class CadastroService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void validarCadastro(CadastroRequestDTO dto) {

        Conta conta = ContaMapper.toEntityCadastro(dto);

        conta.setSenha(passwordEncoder.encode(conta.getSenha()));

        contaRepository.save(conta);
    }
}


