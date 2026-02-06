package br.com.personalproject.siseventos.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @Column(name = "veiculos_cliente")
    @OneToMany (
        mappedBy="cliente",
        cascade = CascadeType.ALL,
        orphanRemoval=true
    )
    private List<Veiculo> veiculosCadastradoList = new ArrayList<>();

    //Metodos
    
}
