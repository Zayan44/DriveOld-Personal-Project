package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { 
}
