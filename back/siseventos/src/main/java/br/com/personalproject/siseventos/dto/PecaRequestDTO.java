package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PecaRequestDTO {

    private String nome;
    private String descricao;
    private String fabricante;
    private BigDecimal preco;
    private int quantidade;
}
