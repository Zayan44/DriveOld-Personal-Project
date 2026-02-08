package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalproject.siseventos.association.ItemOrcamento;
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

    @Autowired
    VeiculoService veiculoService;

    @Transactional(readOnly = true)
    public List<OrcamentoResponseDTO> listarOrcamento() {
        return orcamentoRepository.findAll()
        .stream()
        .map(OrcamentoMapper::toDto)
        .toList();
    }

    @Transactional
    public OrcamentoResponseDTO criarOrcamento(OrcamentoRequestDTO dto, Long id) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        Orcamento orcamento = OrcamentoMapper.toEntity(dto,veiculo);
        orcamento = orcamentoRepository.save(orcamento);
        OrcamentoResponseDTO response = OrcamentoMapper.toDto(orcamento);
        return response;
    }


    @Transactional 
    public void adicionarItemOrcamentoAoOrcamento(Long idOrcamento, ItemOrcamento item ) {
        Orcamento orcamento = orcamentoRepository.findById(idOrcamento).orElseThrow(() -> new RuntimeException("Orcamento não encontrado"));
        orcamento.adicionarItemOrcamento(item);
        orcamentoRepository.save(orcamento);
    }

    @Transactional
    public void removerItemOrcamentoDoOrcamento(Long idOrcamento, Long idItem) {

        Orcamento orcamento = orcamentoRepository.findById(idOrcamento).orElseThrow(() -> new RuntimeException("Orçamento não encontrado"));

        ItemOrcamento item = orcamento.getItensOrcamento()
            .stream()
            .filter(i -> i.getId().equals(idItem))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Item não pertence ao orçamento"));

        orcamento.removerItemOrcamento(item);
        
        orcamentoRepository.save(orcamento);
    }

}
