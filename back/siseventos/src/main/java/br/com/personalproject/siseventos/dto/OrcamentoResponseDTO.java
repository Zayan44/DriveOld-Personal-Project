package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.personalproject.siseventos.enumerated.StatusOrcamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrcamentoResponseDTO {

    private Long id;

    private Long idVeiculo;
    private String nomeMecanico;
    private String placa;
    private String modelo;
    private StatusOrcamento status;
    private BigDecimal valorTotal;

    private List<ItemOrcamentoResponseDTO> itensOrcamento = new ArrayList<>();
}
