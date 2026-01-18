package br.com.personalproject.siseventos.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mecanico extends Pessoa {

    //Atributos
    private String especialidade;
    
    //Construtores
    public Mecanico() {
    };

    public Mecanico(String nome, String cpf, String email, String senha, String telefone, String endereco, String cidade, String estado, String especialidade) {
        super(nome, cpf, email, senha, telefone, endereco, cidade, estado);
        this.especialidade = especialidade;
    }

    //Metodos
}
