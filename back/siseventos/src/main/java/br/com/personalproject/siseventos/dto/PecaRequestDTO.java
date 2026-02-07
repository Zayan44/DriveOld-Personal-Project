package br.com.personalproject.siseventos.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PecaRequestDTO {

    @NotBlank(message = "Insira um nome")
    @Size(min = 3, message = "O nome deve conter mais de três caracteres")
    @Size(max = 100, message = "O nome deve conter menos de 70 caracteres")
    @Pattern(regexp = "^[A-Za-zá-úÁ-Ú ]+$", message = "Insira apenas letras em seu nome")
    private String nome;


    @NotBlank(message = "Insira um nome")
    @Size(min = 5, message = "O nome deve conter mais de três caracteres")
    @Size(max = 500, message = "O nome deve conter menos de 70 caracteres")
    @Pattern(regexp = "^[A-Za-zá-úÁ-Ú ]+$", message = "Insira apenas letras em seu nome")
    private String descricao;


    @NotBlank(message = "Insira um nome")
    @Size(min = 3, message = "O nome deve conter mais de três caracteres")
    @Size(max = 100, message = "O nome deve conter menos de 70 caracteres")
    @Pattern(regexp = "^[A-Za-zá-úÁ-Ú ]+$", message = "Insira apenas letras em seu nome")
    private String fabricante;

    @NotNull(message = "Insira o preço do serviço")
    @Positive(message = "O preço deve ser maior que zero")
    @Digits(integer = 7, fraction = 2, message = "O preço deve ter no máximo 7 dígitos inteiros e 2 decimais")
    private BigDecimal preco;
    private int quantidade;
}
