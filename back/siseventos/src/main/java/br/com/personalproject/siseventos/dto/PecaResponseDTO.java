package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PecaResponseDTO {

    private Long idPeca;
    private String nome;
    private String descricao;
    private String fabricante;
    private BigDecimal preco;
}
