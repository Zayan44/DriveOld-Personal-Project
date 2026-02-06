package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalproject.siseventos.dto.ServicoRequestDTO;
import br.com.personalproject.siseventos.dto.ServicoResponseDTO;
import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.mapper.ServicoMapper;
import br.com.personalproject.siseventos.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    // Listar serviços
    @Transactional(readOnly = true)
    public List<ServicoResponseDTO> listarServico() {

        List<ServicoResponseDTO> response = servicoRepository.findAll()
                .stream()
                .map(ServicoMapper::toDto)
                .toList();

        return response;
    }

    // Cadastrar serviço
    @Transactional
    public ServicoResponseDTO cadastrarServico(ServicoRequestDTO dto) {
        Servico servico = ServicoMapper.toEntity(dto);
        servico = servicoRepository.save(servico);
        ServicoResponseDTO response = ServicoMapper.toDto(servico);
        return response;
    }

    // Atualizar serviço
    @Transactional
    public ServicoResponseDTO atualizarServico(ServicoRequestDTO dto, Long id) {

        Servico servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servico = ServicoMapper.toUpdate(servico,dto);
        servico = servicoRepository.save(servico);
        ServicoResponseDTO response = ServicoMapper.toDto(servico);

        return response;
    }

    // Deletar serviço
    @Transactional
    public void deletarServico(Long id) {
        servicoRepository.deleteById(id);
    }

    // Buscar serviço por id
    @Transactional(readOnly = true)
    public Servico buscarServicoPorId(Long id) {

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        return servico;
    }
}
