package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Cliente;

public interface clienteRepository extends JpaRepository<Cliente, Long> { 
}
