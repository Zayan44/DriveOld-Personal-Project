package br.com.personalproject.siseventos.dto;

import br.com.personalproject.siseventos.enumerated.TipoVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {

    @NotNull(message = "Selecione o tipo do veículo")
    private TipoVeiculo tipo; // enum, validação feita automaticamente pelo NotNull

    @NotBlank(message = "Insira a placa do veículo")
    @Pattern(regexp = "^[A-Z]{3}-\\d{4}$", message = "A placa deve estar no formato ABC-1234")
    private String placa;

    @NotBlank(message = "Insira a marca do veículo")
    @Size(min = 2, max = 50, message = "A marca deve ter entre 2 e 50 caracteres")
    private String marca;

    @NotBlank(message = "Insira o modelo do veículo")
    @Size(min = 1, max = 50, message = "O modelo deve ter entre 1 e 50 caracteres")
    private String modelo;

    @Min(value = 1900, message = "O ano do veículo deve ser maior ou igual a 1900")
    @Max(value = 2030, message = "O ano do veículo deve ser menor ou igual a 2100")
    private int ano;
}

