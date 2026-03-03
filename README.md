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

### Diagrama UML (Em desenvolvimento)

<img width="4059" height="6785" alt="Locadora 3FN Contratos Flow-2026-02-09-125914" src="https://github.com/user-attachments/assets/fd534e99-2bdd-4d0f-a859-d4f2e00ede3c" />

### Organização de Pacotes e Classes

```
src/main/java/br/com/personalproject/siseventos/
├── 📁 association
│   └── 📄 ItemOrcamento.java             
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
│   ├── 📄 ItemOrcamentoService.java    
│   ├── 📄 MecanicoService.java
│   ├── 📄 OrcamentoService.java          
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
├── 📁 security
│   └── 📄 SecurityConfig.java
├── 📁 entity
│   ├── 📄 Pessoa.java                   
│   ├── 📄 Cliente.java
│   ├── 📄 Conta.java
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
│   ├── 📄 Cliente.java
│   ├── 📄 ItemOrcamentoMapper.java
│   ├── 📄 MecanicoMapper.java
│   ├── 📄 OrcamentoMapper.java
│   ├── 📄 PecaMapper.java
│   ├── 📄 ServicoMapper.java
│   ├── 📄 VeiculoMapper.java
│   └── 📄 OrcamentoMapper.java
├── 📁 enumerated
│   ├── 📄 PerfisAutenticacao.java
│   ├── 📄 StatusVeiculo.java
│   ├── 📄 StatusOrcamento.java
│   ├── 📄 TipoItemOrcamento.java
│   └── 📄 TipoVeiculo.java
└── 📄 SiseventosApplication.java
```

---

## 🛠️ Tecnologias Utilizadas 

- Java 21
- PostgreSQL 16
- Spring Security 7.0.3
- JWT
- Lombok
- Spring JPA (Hibernate)
- Validation
---

## 🛠️ Como Executar


### Clonar o repositório

git clone https://github.com/seu-usuario/driveold.git

### Configurar banco de dados

Crie um banco de dados PostgreSQL:

CREATE DATABASE nomedobanco;

### Configurar arquivo application.properties

spring.datasource.username=postgres
spring.datasource.password=senha

spring.datasource.url=jdbc:postgresql://localhost:5432/nomedobanco

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update

### Executar aplicação

./mvnw spring-boot:run

---

## 🤝 Contribua

Sinta-se livre para realizar quaisquer contribuição, ficarei muito feliz.

---


