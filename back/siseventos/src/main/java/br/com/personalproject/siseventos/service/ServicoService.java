package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<List<ServicoResponseDTO>> listarServico() {

        List<ServicoResponseDTO> lista = servicoRepository.findAll()
                .stream()
                .map(ServicoMapper::toDto)
                .toList();

        return ResponseEntity.ok(lista);
    }

    // Cadastrar serviço
    @Transactional
    public ResponseEntity<ServicoResponseDTO> cadastrarServico(ServicoRequestDTO dto) {

        Servico servico = ServicoMapper.toEntity(dto);

        Servico servicoSalvo = servicoRepository.save(servico);

        ServicoResponseDTO response = ServicoMapper.toDto(servicoSalvo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(servicoSalvo.getIdServico())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    // Atualizar serviço
    @Transactional
    public ResponseEntity<ServicoResponseDTO> atualizarServico(ServicoRequestDTO dto, Long id) {

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        // Atualiza campos
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setPreco(dto.getPreco());

        Servico servicoAtualizado = servicoRepository.save(servico);

        return ResponseEntity.ok(ServicoMapper.toDto(servicoAtualizado));
    }

    // Deletar serviço
    @Transactional
    public ResponseEntity<Void> deletarServico(Long id) {

        servicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // Buscar serviço por id
    @Transactional(readOnly = true)
    public Servico buscarServicoPorId(Long id) {

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        return servico;
    }
}
