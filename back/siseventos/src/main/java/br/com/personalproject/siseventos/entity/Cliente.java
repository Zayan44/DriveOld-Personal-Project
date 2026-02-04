package br.com.personalproject.siseventos.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    
}
