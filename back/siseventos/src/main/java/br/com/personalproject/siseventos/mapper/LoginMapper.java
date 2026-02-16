package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.LoginRequestDTO;
import br.com.personalproject.siseventos.entity.Conta;
import br.com.personalproject.siseventos.enumerated.PerfisAutenticao;

public class LoginMapper {
    public static Conta toEntity(LoginRequestDTO dto) {
            Conta entity = new Conta();

            entity.setEmail(dto.getEmail());
            entity.setSenha(dto.getSenha());
            entity.setRole(PerfisAutenticao.ROLE_FUNCIONARIO);

            return entity;
        }
}
