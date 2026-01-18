package br.com.personalproject.siseventos.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class Gestor extends Pessoa {

    //Atributos
    private String time;

    //Construtores
    public Gestor() {
    }

    public Gestor(String nome, String cpf, String email, String senha, String telefone, String endereco, String cidade, String estado, String time) {
        super(nome, cpf, email, senha, telefone, endereco, cidade, estado);
        this.time = time;
    }

    //Metodos
}
