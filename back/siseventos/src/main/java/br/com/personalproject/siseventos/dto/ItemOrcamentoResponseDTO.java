package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;

import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrcamentoResponseDTO {

    private Long id;
    private Long idReferencia; //peca ou servico
    private String nomeReferencia;
    private TipoItemOrcamento tipo;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
}