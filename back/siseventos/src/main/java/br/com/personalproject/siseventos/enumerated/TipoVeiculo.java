package br.com.personalproject.siseventos.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoVeiculo {
    CARRO("Carro"),
    MOTO("Moto");

    private final String descricao;

    @Override
    public String toString() {
        return descricao;
    }
    
}
