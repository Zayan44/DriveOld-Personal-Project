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
public class OrcamentoRequestDTO {

    private String status;
    private BigDecimal desconto;
}
