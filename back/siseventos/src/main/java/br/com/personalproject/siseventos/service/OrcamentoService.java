package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Veiculo;
import br.com.personalproject.siseventos.mapper.MapperOrcamento;
import br.com.personalproject.siseventos.repository.OrcamentoRepository;
import br.com.personalproject.siseventos.repository.VeiculoRepository;
import java.util.List;

@Service
public class OrcamentoService {
    
    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    // Metodo para listar orcamentos
    public List<OrcamentoResponseDTO> listarOrcamento() {
        
        return orcamentoRepository.findAll()
        .stream()
        .map(MapperOrcamento::enviarDTO)
        .toList();
    }

    // Metodo para cadastrar orcamentos
    public ResponseEntity<?> cadastrarOrcamento(@RequestBody Orcamento orcamento, @PathVariable Long idVeiculo) {

        Optional<Veiculo> veiculoSalvoOpt = veiculoRepository.findById(idVeiculo);

        orcamento.setVeiculo(veiculoSalvoOpt.get());
  
        Orcamento orcamentoSalvo = orcamentoRepository.save(orcamento);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(orcamentoSalvo.getIdOrcamento())
        .toUri();

        return ResponseEntity.created(location).body(orcamentoSalvo);
     }   

    // Metodo para deletar orcamento
        public ResponseEntity<?> deletarOrcamento(@PathVariable Long idVeiculo) {

        orcamentoRepository.deleteById(idVeiculo);

        return ResponseEntity.noContent().build();
    }
}
