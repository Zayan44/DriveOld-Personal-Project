package br.com.personalproject.siseventos.dto;

import br.com.personalproject.siseventos.enumerated.StatusOrcamento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrcamentoRequestDTO {

    @NotNull(message = "O status do orcamento não corresponde ao padrão")
    private StatusOrcamento status;

    @NotNull(message = "Escolha um mecânico")
    private Long idMencanico;
}
