package br.com.personalproject.siseventos.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDTO {

    private Long idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;

    private List<VeiculoResponseDTO> veiculos = new ArrayList<>();
}
