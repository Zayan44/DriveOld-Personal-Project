package br.com.personalproject.siseventos.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalproject.siseventos.association.ItemOrcamento;
import br.com.personalproject.siseventos.dto.ItemOrcamentoRequestDTO;
import br.com.personalproject.siseventos.dto.ItemOrcamentoResponseDTO;
import br.com.personalproject.siseventos.entity.Orcamento;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.enumerated.TipoItemOrcamento;
import br.com.personalproject.siseventos.mapper.ItemOrcamentoMapper;
import br.com.personalproject.siseventos.repository.ItemOrcamentoRepository;
import br.com.personalproject.siseventos.repository.OrcamentoRepository;
import br.com.personalproject.siseventos.repository.PecaRepository;
import br.com.personalproject.siseventos.repository.ServicoRepository;

@Service
public class ItemOrcamentoService {

    @Autowired
    private ItemOrcamentoRepository itemOrcamentoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PecaRepository pecaRepository;

    @Autowired
    private OrcamentoRepository orcamentoRepository;


    @Transactional
    public ItemOrcamentoResponseDTO criarItemOrcamento(ItemOrcamentoRequestDTO dto) {

        Orcamento orcamento = orcamentoRepository.findById(dto.getIdOrcamento()).orElseThrow(() -> new RuntimeException("Orçamento não encontrado"));

        Servico servico = null;
        Peca peca = null;

        if (TipoItemOrcamento.PECA.equals(dto.getTipo())) {
            peca = pecaRepository.findById(dto.getIdReferencia()).orElseThrow(() -> new RuntimeException("Peça não encontrada"));
        } 
        
        else if (TipoItemOrcamento.SERVICO.equals(dto.getTipo())) {
            servico = servicoRepository.findById(dto.getIdReferencia()).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        }

        ItemOrcamento itemOrcamento = ItemOrcamentoMapper.toEntity(dto, servico, peca);

        itemOrcamento.setOrcamento(orcamento);

        definirValorUnitario(itemOrcamento);

        calcularValorTotal(itemOrcamento);

        itemOrcamentoRepository.save(itemOrcamento);

        return ItemOrcamentoMapper.toDto(itemOrcamento);
    }

    @Transactional
    public void deletarItemOrcamento(Long id) {

        ItemOrcamento item = itemOrcamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        itemOrcamentoRepository.delete(item);
    }

    private void definirValorUnitario(ItemOrcamento item) {

        if (TipoItemOrcamento.PECA.equals(item.getTipo())) {
            item.setValorUnitario(item.getPeca().getPreco());
        } else {
            item.setValorUnitario(item.getServico().getPreco());
        }
    }

    private void calcularValorTotal(ItemOrcamento item) {

        BigDecimal subtotal = item.getValorUnitario()
                .multiply(BigDecimal.valueOf(item.getQuantidade()));

        item.setValorTotal(subtotal);
    }
}
