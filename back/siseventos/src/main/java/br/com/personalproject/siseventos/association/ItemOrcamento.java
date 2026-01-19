package br.com.personalproject.siseventos.association;

import java.math.BigDecimal;

import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.entity.Servico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemOrcamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_orcamento_id")
    Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "fk_peca-id")
    Peca peca;

    @ManyToOne
    @JoinColumn(name = "fk_servico_id")
    Servico servico;


    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
}