package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoResponseDTO {

    private Long idServico;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
