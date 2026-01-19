package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Peca;

public interface PecaRepository extends JpaRepository<Peca,Long> {
}
