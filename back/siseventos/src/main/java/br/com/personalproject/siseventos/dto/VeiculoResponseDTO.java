package br.com.personalproject.siseventos.dto;

import br.com.personalproject.siseventos.enumerated.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponseDTO {

    private Long id;
    private TipoVeiculo tipo;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private Long idCliente;
}
