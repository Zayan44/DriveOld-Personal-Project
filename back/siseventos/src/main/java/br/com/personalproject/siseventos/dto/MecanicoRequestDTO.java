package br.com.personalproject.siseventos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MecanicoRequestDTO {
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;

    private String especialidade;

    List<ItemOrcamentoRequestDTO> itensOrcamento = new ArrayList<>();
}
