package br.com.personalproject.siseventos.mapper;

import br.com.personalproject.siseventos.dto.CadastroRequestDTO;
import br.com.personalproject.siseventos.entity.Conta;
import br.com.personalproject.siseventos.enumerated.PerfisAutenticao;


public class ContaMapper {
    public static Conta toEntityCadastro(CadastroRequestDTO dto) {

        Conta entity = new Conta();

        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setRole(PerfisAutenticao.ROLE_FUNCIONARIO);
        return entity;
    }
}
