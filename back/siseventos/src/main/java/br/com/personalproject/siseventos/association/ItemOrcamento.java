package br.com.personalproject.siseventos.association;

import java.math.BigDecimal;

import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long idItemOrcamento;

    @ManyToOne
    @JoinColumn(name = "fk_orcamento_id",nullable = false)
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "fk_peca_id")
    private Peca peca;

    @ManyToOne
    @JoinColumn(name = "fk_servico_id")
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private TipoItemOrcamento tipo;

    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    //Metodos

    //metodo para calcularTotal
    public void calcularValorTotal(){
        valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

}

