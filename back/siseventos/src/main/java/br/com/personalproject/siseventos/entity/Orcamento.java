package br.com.personalproject.siseventos.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import jakarta.persistence.CascadeType;
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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private String status;
    private BigDecimal valorTotal;
    private BigDecimal valorServico;
    private BigDecimal valorPeca;
    private BigDecimal desconto;
    
        //metodo para adicionar ItemOrcamento
        public void adicionarItemOrcamento(ItemOrcamento itemOrcamento) {
            
            itemOrcamento.setOrcamento(this);
            this.itensOrcamento.add(itemOrcamento);
        }


}
