package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrcamentoRequestDTO {

    private Long idVeiculo;

    private String status;
    private BigDecimal desconto;

    private List<ItemOrcamentoRequestDTO> itens = new ArrayList<>();
}
