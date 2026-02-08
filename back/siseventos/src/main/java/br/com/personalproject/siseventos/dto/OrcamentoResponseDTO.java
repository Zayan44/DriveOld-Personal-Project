package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrcamentoResponseDTO {

    private Long idOrcamento;

    private Long idVeiculo;
    private String placa;
    private String modelo;
    private String status;
    private BigDecimal valorTotal;
    private BigDecimal desconto;

    private List<ItemOrcamentoResponseDTO> detalhes = new ArrayList<>();
}
