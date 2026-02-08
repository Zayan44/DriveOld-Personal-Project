package br.com.personalproject.siseventos.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "orcamentos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idOrcamento;

    @ManyToOne
    @JoinColumn(name = "fk_veiculo_id", nullable = false)
    private Veiculo veiculo;

    @OneToMany (
        mappedBy="orcamento",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ItemOrcamento> itensOrcamento = new ArrayList<>();

    @Column(name = "status")
    private String status;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "desconto")
    private BigDecimal desconto;
    
        //regras

    public void adicionarItemOrcamento(ItemOrcamento itemOrcamento) {
        itemOrcamento.setOrcamento(this);
        this.itensOrcamento.add(itemOrcamento);
    }

    public void removerItemOrcamento(ItemOrcamento itemOrcamento) {
        itensOrcamento.remove(itemOrcamento);
    } 
    
    public void calcularValoresTotais(ItemOrcamento itemOrcamento) {
        itemOrcamento.setValorTotal(itemOrcamento.getValorUnitario().multiply(BigDecimal.valueOf(itemOrcamento.getQuantidade()))); 
    }
}
