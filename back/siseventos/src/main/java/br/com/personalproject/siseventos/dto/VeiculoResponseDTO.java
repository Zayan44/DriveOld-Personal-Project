package br.com.personalproject.siseventos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResponseDTO {

    private String tipo;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private Long idCliente;
}
