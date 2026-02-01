package br.com.personalproject.siseventos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculo;

    @ManyToOne
    @JoinColumn(name = "fk_cliente_id",nullable=false)
    private Cliente cliente;

    private String proprietario;
    private String tipo;  //caminhao, carro, moto
    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    //Metodos


}
