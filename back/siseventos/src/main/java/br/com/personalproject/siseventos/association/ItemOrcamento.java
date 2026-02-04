package br.com.personalproject.siseventos.association;

import java.math.BigDecimal;

import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Associasse com peca e servico

@Table(name = "Item_Orcamento")
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
    @JoinColumn(name = "fk_orcamento",nullable = false)
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "fk_peca")
    private Peca peca;

    @ManyToOne
    @JoinColumn(name = "fk_servico")
    private Servico servico;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoItemOrcamento tipo;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    //Metodos

    //metodo para calcularTotal
    public void calcularValorTotal(){
        valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

}

