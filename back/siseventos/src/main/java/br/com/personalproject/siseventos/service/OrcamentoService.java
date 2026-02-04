package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.OrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Veiculo;
import br.com.personalproject.siseventos.mapper.OrcamentoMapper;
import br.com.personalproject.siseventos.repository.OrcamentoRepository;


@Service
public class OrcamentoService {
    
    @Autowired
    OrcamentoRepository orcamentoRepository;

    VeiculoService veiculoService;

    // Metodo para listar orcamentos
    public List<OrcamentoResponseDTO> listarOrcamento() {
        
        return orcamentoRepository.findAll()
        .stream()
        .map(OrcamentoMapper::toDto)
        .toList();
    }

    // Metodo para cadastrar orcamento
    public ResponseEntity<OrcamentoResponseDTO> criarOrcamento(OrcamentoRequestDTO dto, Long idVeiculo) {

        Veiculo veiculo = veiculoService.buscarVeiculoPorId(dto.getIdVeiculo());

        Orcamento orcamento = OrcamentoMapper.toEntity(dto,veiculo);

        orcamentoRepository.save(orcamento);

        OrcamentoResponseDTO dtoResponse = OrcamentoMapper.toDto(orcamento);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(dtoResponse.getIdOrcamento())
        .toUri();

        return ResponseEntity.created(location).body(dtoResponse);
    }

    // Metodo para deletar orcamento
    public ResponseEntity<?> deletarOrcamento(@PathVariable Long idOrcamento) {

        orcamentoRepository.deleteById(idOrcamento);

        return ResponseEntity.noContent().build();
    }
}
