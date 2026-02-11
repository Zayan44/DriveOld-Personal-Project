package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.dto.OrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.OrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Mecanico;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.entity.Veiculo;
import br.com.personalproject.siseventos.enumerated.StatusOrcamento;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;
import br.com.personalproject.siseventos.mapper.OrcamentoMapper;
import br.com.personalproject.siseventos.repository.MecanicoRepository;
import br.com.personalproject.siseventos.repository.OrcamentoRepository;
import br.com.personalproject.siseventos.repository.PecaRepository;
import br.com.personalproject.siseventos.repository.VeiculoRepository;

@Service
public class OrcamentoService {
    
    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    PecaRepository pecaRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    MecanicoRepository mecanicoRepository;

    @Transactional(readOnly = true)
    public List<OrcamentoResponseDTO> listarOrcamento() {
        return orcamentoRepository.findAll()
        .stream()
        .map(OrcamentoMapper::toDto)
        .toList();
    }

    @Transactional
    public OrcamentoResponseDTO criarOrcamento(OrcamentoRequestDTO dto, Long idVeiculo, Long idMecanico) { //resolver implementação do mecanico
        Mecanico mecanico = mecanicoRepository.findById(idMecanico).orElseThrow(() -> new RuntimeException("Mecanico não encontrado"));
        Veiculo veiculo = veiculoRepository.findById(idVeiculo).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        Orcamento orcamento = OrcamentoMapper.toEntity(dto,veiculo,mecanico);
        orcamento = orcamentoRepository.save(orcamento);
        OrcamentoResponseDTO response = OrcamentoMapper.toDto(orcamento);
        return response;
    }


    @Transactional 
    public void adicionarItemOrcamentoAoOrcamento(Long idOrcamento, ItemOrcamento item, Long idPeca ) {
        Orcamento orcamento = orcamentoRepository.findById(idOrcamento).orElseThrow(() -> new RuntimeException("Orcamento não encontrado"));
        item.setQuantidade(item.getPeca().getQuantidade() - item.getQuantidade());
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

    @Transactional
    public void cancelarOrcamento(Long idOrcamento) {
        Orcamento orcamento = orcamentoRepository.findById(idOrcamento)
                .orElseThrow(() -> new RuntimeException("Orçamento não encontrado"));

        for (ItemOrcamento item : orcamento.getItensOrcamento()) {
            if (TipoItemOrcamento.PECA.equals(item.getTipo())) {
                Peca peca = item.getPeca();
                peca.setQuantidade(peca.getQuantidade() + item.getQuantidade());
                pecaRepository.save(peca);
            }
    }

    orcamento.setStatus(StatusOrcamento.CANCELADO);
    orcamentoRepository.save(orcamento);
}

}
