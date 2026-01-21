package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrcamentoResponseDTO {

    private Long idOrcamento;

    private Long idVeiculo;
    private String placa;
    private String modelo;

    private String status;
    private BigDecimal valorTotal;
    private BigDecimal valorServico;
    private BigDecimal valorPeca;
    private BigDecimal desconto;

    private List<ItemOrcamentoResponseDTO> itens = new ArrayList<>();
}
