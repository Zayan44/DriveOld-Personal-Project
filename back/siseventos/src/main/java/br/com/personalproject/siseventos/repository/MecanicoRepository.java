package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Mecanico;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
    
}
