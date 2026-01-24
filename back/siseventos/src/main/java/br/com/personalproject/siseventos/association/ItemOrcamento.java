package br.com.personalproject.siseventos.association;

import java.math.BigDecimal;

import br.com.personalproject.siseventos.entity.Orcamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Associasse com peca e servico

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrcamento {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_orcamento_id",nullable = false)
    Orcamento orcamento;

    @OneToMany
    @JoinColumn(name = "fk_pecaouservico")
    private Long idReferencia;

    private String tipo;

    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    //Metodos

    //metodo para calcularTotal
    public void calcularValorTotal(){
        valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

}

