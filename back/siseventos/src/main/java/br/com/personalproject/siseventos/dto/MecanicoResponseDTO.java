package br.com.personalproject.siseventos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MecanicoResponseDTO {
    
    private Long idPessoa; 
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;

    private String especialidade;
}
