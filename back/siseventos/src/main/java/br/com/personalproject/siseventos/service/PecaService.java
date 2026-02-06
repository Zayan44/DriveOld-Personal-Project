package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<PecaResponseDTO> listarPeca() {

        List<PecaResponseDTO> response = pecaRepository.findAll()
                .stream()
                .map(PecaMapper::toDto)
                .toList();

        return response;
    }

    // Cadastrar peça
    @Transactional
    public PecaResponseDTO cadastrarPeca(PecaRequestDTO dto) {
        Peca peca = PecaMapper.toEntity(dto);
        Peca pecaSalva = pecaRepository.save(peca);
        PecaResponseDTO response = PecaMapper.toDto(pecaSalva);
        return response;
    }

    // Atualizar peça
    @Transactional
    public PecaResponseDTO atualizarPeca(PecaRequestDTO dto, Long id) {
        Peca pecaEncontrada = pecaRepository.findById(id).orElseThrow(() -> new RuntimeException("Peça não encontrada"));
        Peca pecaAtualizada = PecaMapper.toUpdate(pecaEncontrada,dto);
        Peca pecaSalva = pecaRepository.save(pecaAtualizada);
        PecaResponseDTO response = PecaMapper.toDto(pecaSalva);
        return response;
    }

    // Deletar peça
    @Transactional
    public void deletarPeca(Long id) {
        pecaRepository.deleteById(id);
    }

    // Buscar por id
    @Transactional(readOnly = true)
    public PecaResponseDTO buscarPecaPorId(Long id) {
        Peca peca = pecaRepository.findById(id).orElseThrow(() -> new RuntimeException("Peça não encontrada"));
        return PecaMapper.toDto(peca);
    }

}
