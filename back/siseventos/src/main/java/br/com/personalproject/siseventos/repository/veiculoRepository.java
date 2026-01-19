package br.com.personalproject.siseventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personalproject.siseventos.entity.Veiculo;

public interface veiculoRepository extends JpaRepository<Veiculo, Long> {
}
