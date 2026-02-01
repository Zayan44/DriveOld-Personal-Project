package br.com.personalproject.siseventos.dto;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrcamentoRequestDTO {
    
    private Long idReferencia; //peca ou servico

    private TipoItemOrcamento tipo; //PECA ou SERVICO

    private int quantidade;
    
}
