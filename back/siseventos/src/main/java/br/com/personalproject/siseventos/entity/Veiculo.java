package br.com.personalproject.siseventos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Veiculo {
    

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculo;

    private Cliente proprietario;
    private String tipo;  //caminhao, carro, moto
    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    //Construtores

    public Veiculo() {
    }

    public Veiculo(String placa, String marca, String modelo, int ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    //Metodos
}
