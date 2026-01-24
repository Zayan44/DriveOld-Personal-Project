package br.com.personalproject.siseventos.dto;

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
    private String tipo;
    private int quantidade;
    
}
