package br.com.personalproject.siseventos.exception.business.veiculo;

import br.com.personalproject.siseventos.exception.categories.veiculo.VeiculoExceptionCategory;

public class VeiculoNaoEncontradoException extends VeiculoExceptionCategory {
    public VeiculoNaoEncontradoException(String message) {
        super(message);
    }
}
