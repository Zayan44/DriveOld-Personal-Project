package br.com.personalproject.siseventos.entity;

import br.com.personalproject.siseventos.enumerated.PerfisAutenticao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email",unique = true, nullable = false)
    private String email;

    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private PerfisAutenticao role;
}
