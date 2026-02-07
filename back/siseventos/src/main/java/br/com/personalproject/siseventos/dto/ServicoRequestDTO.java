package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRequestDTO {

    @NotBlank(message = "Insira o nome do serviço")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "O nome deve conter apenas letras e espaços")
    private String nome;

    @NotBlank(message = "Insira uma descrição do serviço")
    @Size(min = 5, max = 500, message = "A descrição deve ter entre 5 e 500 caracteres")
    private String descricao;

    @NotNull(message = "Insira o preço do serviço")
    @Positive(message = "O preço deve ser maior que zero")
    @Digits(integer = 7, fraction = 2, message = "O preço deve ter no máximo 7 dígitos inteiros e 2 decimais")
    private BigDecimal preco;

}

