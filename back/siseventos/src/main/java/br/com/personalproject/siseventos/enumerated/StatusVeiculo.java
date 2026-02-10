package br.com.personalproject.siseventos.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusVeiculo {
    CADASTRADO("Cadastrado"),
    EMMANUTENCAO("Em manutenção");

    private final String descricao;

    @Override
    public String toString() {
        return descricao;
    }
}
