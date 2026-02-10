package br.com.personalproject.siseventos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long>{
    Optional<Conta> findByEmail(String email);
}
