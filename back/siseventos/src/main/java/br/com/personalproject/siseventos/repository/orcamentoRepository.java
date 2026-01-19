package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Orcamento;

public interface orcamentoRepository extends JpaRepository<Orcamento, Long> {    
}
