package br.com.personalproject.siseventos.enumerated;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public enum TipoItemOrcamento {
    PECA("Peça"),
    SERVICO("Serviço");

    private final String descricao;

    @Override
    public String toString() {
        return descricao;
    }
}
