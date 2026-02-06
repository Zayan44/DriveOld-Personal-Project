package br.com.personalproject.siseventos.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "clientes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Pessoa {
        
    //Atributos
    @OneToMany (
        mappedBy="cliente",
        cascade = CascadeType.ALL,
        orphanRemoval=true
    )
    private List<Veiculo> veiculosCadastradoList = new ArrayList<>();

    //Metodos
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculosCadastradoList.add(veiculo);
        veiculo.setCliente(this);
    }
    
    public void removerVeiculo(Veiculo veiculo){
        veiculosCadastradoList.remove(veiculo);
        veiculo.setCliente(null);
    }
}
