package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.PecaRequestDTO;
import br.com.personalproject.siseventos.dto.PecaResponseDTO;
import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.mapper.PecaMapper;
import br.com.personalproject.siseventos.repository.PecaRepository;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    // Listar peças
    @Transactional(readOnly = true)
    public ResponseEntity<List<PecaResponseDTO>> listarPeca() {

        List<PecaResponseDTO> lista = pecaRepository.findAll()
                .stream()
                .map(PecaMapper::toDto)
                .toList();

        return ResponseEntity.ok(lista);
    }

    // Cadastrar peça
    @Transactional
    public ResponseEntity<PecaResponseDTO> cadastrarPeca(PecaRequestDTO dto) {

        Peca peca = PecaMapper.toEntity(dto);

        Peca pecaSalva = pecaRepository.save(peca);

        PecaResponseDTO response = PecaMapper.toDto(pecaSalva);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pecaSalva.getIdPeca())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    // Atualizar peça
    @Transactional
    public ResponseEntity<PecaResponseDTO> atualizarPeca(PecaRequestDTO dto, Long id) {

        Peca peca = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada"));

        // Atualiza campos
        peca.setNome(dto.getNome());
        peca.setPreco(dto.getPreco());
        peca.setQuantidadeEstoque(dto.getQuantidadeEstoque());

        Peca pecaAtualizada = pecaRepository.save(peca);

        return ResponseEntity.ok(PecaMapper.toDto(pecaAtualizada));
    }

    // Deletar peça
    @Transactional
    public ResponseEntity<Void> deletarPeca(Long id) {

        pecaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // Buscar por id
    @Transactional(readOnly = true)
    public PecaResponseDTO buscarPecaPorId(Long id) {

        Peca peca = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada"));

        return PecaMapper.toDto(peca);
    }

}
