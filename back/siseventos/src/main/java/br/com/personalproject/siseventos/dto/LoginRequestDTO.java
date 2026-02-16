package br.com.personalproject.siseventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {
    @NotBlank(message = "O campo Longin precisa ser preenchido")
    @Size(min = 10,max = 70, message = "O campo senha precisa estar entre 8 e 70 caracteres")
    private String email;

    @NotBlank(message = "O campo senha precisa ser preenchido")
    @Size(min = 8,max = 70, message = "O campo senha precisa estar entre 8 e 70 caracteres")
    private String senha;
}
