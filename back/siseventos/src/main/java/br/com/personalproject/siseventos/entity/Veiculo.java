package br.com.personalproject.siseventos.entity;

import br.com.personalproject.siseventos.enumerated.TipoVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.EnumType;

@Table(name = "veiculos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idVeiculo;

    @ManyToOne
    @JoinColumn(name = "fk_cliente_id",nullable=false)
    private Cliente cliente;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;  //caminhao, carro, moto

    @Column(name = "proprietario")
    private String proprietario;

    @Column(name = "placa")
    private String placa;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private int ano;

    //Metodos
}
