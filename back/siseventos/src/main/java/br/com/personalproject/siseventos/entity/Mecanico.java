package br.com.personalproject.siseventos.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "mecanicos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mecanico extends Pessoa {

    //Atributos
    @Column(name = "especialidade")
    private String especialidade;
    
    //Metodos
}
