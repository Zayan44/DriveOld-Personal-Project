# DriveOld
> **EM DESENVOLVIMENTO**

## 🚀 Sobre

Sistema para controle de pessoas e demandas em uma oficina mecânica

### Objetivos do Sistema
- Centralizar clientes e funcionários com autenticação
- Criar orçamentos vinculados a veículos
- Associar peças e serviços a um orçamento
- Calcular valores automaticamente
- Manter histórico de orçamentos
- Facilitar futuras expansões (ordem de serviço, faturamento, etc.)
 
---

## 📁 Estrutura do Projeto

```
src/main/java/br/com/personalproject/siseventos/
├── 📁 association
│   └── 📄 ItemOrcamento.java             # Entidade de ligação (Many-to-Many de Peca e Servico com Orcamento)
├── 📁 controller
│   ├── 📄 ClienteController.java
│   ├── 📄 ItemOrcamentoController.java
│   ├── 📄 MecanicoController.java
│   ├── 📄 OrcamentoController.java
│   ├── 📄 PecaController.java
│   ├── 📄 ServicoController.java
│   └── 📄 VeiculoController.java
├── 📁 service
│   ├── 📄 ClienteService.java
│   ├── 📄 ItemOrcamentoService.java      # Lógica de cálculo de subtotal
│   ├── 📄 MecanicoService.java
│   ├── 📄 OrcamentoService.java          # Lógica de cálculo do valor total
│   ├── 📄 PecaService.java
│   ├── 📄 ServicoService.java
│   └── 📄 VeiculoService.java
├── 📁 repository
│   ├── 📄 ClienteRepository.java
│   ├── 📄 ItemOrcamentoRepository.java
│   ├── 📄 MecanicoRepository.java
│   ├── 📄 OrcamentoRepository.java
│   ├── 📄 PecaRepository.java
│   ├── 📄 ServicoRepository.java
│   └── 📄 VeiculoRepository.java
├── 📁 entity
│   ├── 📄 Pessoa.java                   # @MappedSuperclass
│   ├── 📄 Cliente.java
│   ├── 📄 Mecanico.java
│   ├── 📄 Orcamento.java
│   ├── 📄 Peca.java
│   ├── 📄 Servico.java
│   └── 📄 Veiculo.java
├── 📁 dto
│   ├── 📄 ClienteRequestDTO.java / ClienteResponseDTO.java
│   ├── 📄 ItemOrcamentoRequestDTO.java / ItemOrcamentoResponseDTO.java
│   ├── 📄 MecanicoRequestDTO.java / MecanicoResponseDTO.java
│   ├── 📄 OrcamentoRequestDTO.java / OrcamentoResponseDTO.java
│   ├── 📄 PecaRequestDTO.java / PecaResponseDTO.java
│   ├── 📄 ServicoRequestDTO.java / ServicoResponseDTO.java
│   └── 📄 VeiculoRequestDTO.java / VeiculoResponseDTO.java
├── 📁 mapper
│   ├── 📄 MapperItemOrcamento.java
│   └── 📄 MapperOrcamento.java
├── 📁 enumerated
│   └── 📄 TipoItemOrcamento.java         # Enum (PECA, SERVICO)
└── 📄 SiseventosApplication.java         # Classe Principal
```

---

## 🛠️ Instalação

### Pré Requisitos
- Java 25
---

## 🤝 Contribua

Sinta-se livre para realizar quaisquer contribuição, ficarei muito feliz.

---


