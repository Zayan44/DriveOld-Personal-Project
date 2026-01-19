package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
