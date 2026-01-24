package br.com.personalproject.siseventos.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;

    private List<VeiculoRequestDTO> veiculos = new ArrayList<>();
}
