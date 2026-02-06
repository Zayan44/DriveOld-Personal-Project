package br.com.personalproject.siseventos.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pecas")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Peca {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Long idPeca;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")    
    private String descricao;
    
    @Column(name = "fabricante")
    private String fabricante;
    
    @Column(name = "preco")
    private BigDecimal preco;
    
    @Column(name = "quantidade")
    private int quantidadeEstoque;
}
