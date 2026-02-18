package br.com.personalproject.siseventos.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.personalproject.siseventos.dto.CadastroRequestDTO;
import br.com.personalproject.siseventos.entity.Conta;
import br.com.personalproject.siseventos.enumerated.PerfisAutenticao;


public class ContaMapper {

    public static Conta toEntityCadastro(CadastroRequestDTO dto, PasswordEncoder passwordEncoder) {

        Conta entity = new Conta();

        entity.setEmail(dto.getEmail());
        entity.setSenha(passwordEncoder.encode(dto.getSenha()));
        entity.setRole(PerfisAutenticao.FUNCIONARIO);
        return entity;
    }
}
