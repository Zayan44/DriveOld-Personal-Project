package br.com.personalproject.siseventos.entity;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
public class Cliente extends Pessoa {
        
    //Atributos
    private ArrayList<Veiculo> veiculosCadastradoList = new ArrayList<>();

    //Construtores
    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String senha, String telefone, String endereco, String cidade, String estado, String preferencia) {
        super(nome, cpf, email, senha, telefone, endereco, cidade, estado);
    }

    //Metodos
    
}
