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


//Associasse com peca e servico
@Entity
public class ItemOrcamento {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_orcamento_id",nullable = false)
    Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "fk_peca-id",nullable = false)
    Peca peca;

    @ManyToOne
    @JoinColumn(name = "fk_servico_id",nullable = false)
    Servico servico;

    private Long idReferencia;
    private String tipo;

    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
}