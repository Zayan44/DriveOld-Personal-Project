package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Peca;

public interface pecaRepository extends JpaRepository<Peca,Long> {
}
