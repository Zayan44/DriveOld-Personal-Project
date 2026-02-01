package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.association.ItemOrcamento;

public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento, Long> {
    
}
