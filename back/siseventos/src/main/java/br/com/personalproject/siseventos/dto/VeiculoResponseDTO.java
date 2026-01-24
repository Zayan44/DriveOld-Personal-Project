package br.com.personalproject.siseventos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponseDTO {

    private String tipo;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private Long idCliente;
}
