package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Servico;

public interface servicoRepository extends JpaRepository<Servico, Long> {
}
