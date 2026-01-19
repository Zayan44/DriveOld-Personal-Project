package br.com.personalproject.siseventos.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
public class Cliente extends Pessoa {
        
    //Atributos
    @OneToMany(
        mappedBy="cliente",
        cascade = CascadeType.ALL,
        orphanRemoval=true
    )
    private List<Veiculo> veiculosCadastradoList = new ArrayList<>();

    //Construtores
    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String senha, String telefone, String endereco, String cidade, String estado, String preferencia) {
        super(nome, cpf, email, senha, telefone, endereco, cidade, estado);
    }

    //Metodos
    
}
