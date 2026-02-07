package br.com.personalproject.siseventos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MecanicoRequestDTO {

    @NotBlank(message = "Insira o nome do mecânico")
    @Size(min = 3, message = "O nome deve conter mais de três caracteres")
    @Size(max = 100, message = "O nome deve conter menos de 100 caracteres")
    @Pattern(regexp = "^[A-Za-zá-úÁ-Ú ]+$", message = "Insira apenas letras no nome")
    private String nome;

    @NotBlank(message = "Insira o CPF do mecânico")
    @Pattern(regexp = "\\d+{3}.\\d+{3}.\\d+{3}.\\d+{2}", message = "O CPF deve conter apenas números e pontos")
    private String cpf;
        
    @NotBlank(message = "Insira o E-mail do mecânico")
    @Email(message = "Insira um E-mail válido")
    @Size(max = 70, message = "O E-mail deve conter no máximo 70 caracteres")
    private String email;

    @NotBlank(message = "Insira o número de telefone do mecânico")
    @Pattern(regexp = "\\d{2} \\d{9}", message = "Insira caracteres válidos para um número de celular")
    private String telefone;

    @NotBlank(message = "Insira o endereço do mecânico")
    @Size(min = 5, max = 150, message = "O endereço deve ter entre 5 e 150 caracteres")
    private String endereco;

    @NotBlank(message = "Insira o bairro do mecânico")
    @Size(min = 3, max = 50, message = "O bairro deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú ]+$", message = "O bairro deve conter apenas letras e espaços")
    private String bairro;

    @NotBlank(message = "Insira a cidade do mecânico")
    @Size(min = 3, max = 50, message = "A cidade deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "A cidade deve conter apenas letras e espaços")
    private String cidade;

    @NotBlank(message = "Insira o estado do mecânico")
    @Size(min = 2, max = 2, message = "O estado deve ter entre 2 caracteres")
    @Pattern(regexp = "^[A-Z]+$", message = "O estado deve conter apenas letras")
    private String estado;

    @NotBlank(message = "Insira a especialidade do mecânico")
    @Size(min = 3, max = 70, message = "A especialidade deve conter entre 3 e 70 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "A especialidade deve conter apenas letras e espaços")
    private String especialidade;
}
