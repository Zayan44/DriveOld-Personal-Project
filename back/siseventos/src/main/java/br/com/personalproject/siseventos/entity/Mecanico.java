package br.com.personalproject.siseventos.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mecanico extends Pessoa {

    //Atributos
    private String especialidade;
    
    //Metodos
}
