package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrcamentoRequestDTO {

    private Long idVeiculo;

    private String status;
    private BigDecimal desconto;

    private List<ItemOrcamento> itens = new ArrayList<>();
}
