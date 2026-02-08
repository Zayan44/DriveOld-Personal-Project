package br.com.personalproject.siseventos.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusOrcamento {
    CANCELADO("Cancelado"),
    AGUARDANDOPAGAMENTO("Aguardando pagamento"),
    PAGO("Pago");

    private final String descricao;

    @Override
    public String toString() {
        return descricao;
    }
}
