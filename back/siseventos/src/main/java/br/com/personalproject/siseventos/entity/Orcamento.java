package br.com.personalproject.siseventos.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orcamento {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrcamento;

    private Cliente cliente;
    private Veiculo veiculo;
    private String status;
    private BigDecimal valorTotal;
    private BigDecimal valorServico;
    private BigDecimal valorPeca;
    private BigDecimal desconto;

    public Orcamento() {}

    public Orcamento(Cliente cliente,Veiculo veiculo, String status, BigDecimal valorTotal, BigDecimal valorServico, BigDecimal valorPeca, BigDecimal desconto) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.status = status;
        this.valorTotal = valorTotal;
        this.valorServico = valorServico;
        this.valorPeca = valorPeca;
        this.desconto = desconto;
    }
}
