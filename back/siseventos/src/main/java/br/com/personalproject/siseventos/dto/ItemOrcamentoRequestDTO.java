package br.com.personalproject.siseventos.dto;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrcamentoRequestDTO {
    
    @NotNull(message = "O id de orcamento é obrigatório")
    private Long idOrcamento;

    @NotNull(message = "O id de referência é obrigatório")
    private Long idReferencia;              // Pode ser peça ou serviço

    @NotNull(message = "O tipo do item é obrigatório")
    private TipoItemOrcamento tipo;        

    @Positive(message = "A quantidade deve ser no mínimo 1")
    private int quantidade;
}
