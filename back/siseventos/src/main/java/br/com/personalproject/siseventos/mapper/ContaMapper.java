package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.LoginRequestDTO;
import br.com.personalproject.siseventos.entity.Conta;


public class ContaMapper {
    public static void toEntity(LoginRequestDTO dto) {

        Conta entity = new Conta();

        entity.setEmail(dto.getLogin());
        entity.setSenha(dto.getSenha());
    }
}
