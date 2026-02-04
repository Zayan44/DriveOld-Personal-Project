package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.dto.MecanicoRequestDTO;
import br.com.personalproject.siseventos.dto.MecanicoResponseDTO;
import br.com.personalproject.siseventos.entity.Mecanico;
import br.com.personalproject.siseventos.mapper.MecanicoMapper;
import br.com.personalproject.siseventos.repository.MecanicoRepository;

@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    // Método para listar mecânicos
    @Transactional(readOnly = true)
    public ResponseEntity<List<MecanicoResponseDTO>> listarMecanico() {

        List<Mecanico> mecanicos = mecanicoRepository.findAll();

        List<MecanicoResponseDTO> dto = mecanicos
                .stream()
                .map(MecanicoMapper::toDto)
                .toList();

        return ResponseEntity.ok(dto);
    }

    // Método para cadastrar mecânicos
    @Transactional
    public ResponseEntity<MecanicoResponseDTO> cadastrarMecanico(MecanicoRequestDTO dto) {

        Mecanico mecanico = MecanicoMapper.toEntity(dto);

        Mecanico mecanicoSalvo = mecanicoRepository.save(mecanico);

        MecanicoResponseDTO dtoResponse = MecanicoMapper.toDto(mecanicoSalvo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mecanicoSalvo.getIdPessoa())
                .toUri();

        return ResponseEntity.created(location).body(dtoResponse);
    }

    @Transactional
    public ResponseEntity<MecanicoResponseDTO> atualizarMecanico(MecanicoRequestDTO dto, Long id) {

    Mecanico mecanico = MecanicoMapper.toEntity(dto);

    mecanico.setIdPessoa(id);

    Mecanico mecanicoAtualizado = mecanicoRepository.save(mecanico);

    MecanicoResponseDTO dtoResponse = MecanicoMapper.toDto(mecanicoAtualizado);

    return ResponseEntity.ok(dtoResponse);
    }

    // Método para deletar mecânicos
    @Transactional
    public ResponseEntity<Void> deletarMecanico(Long id) {

        mecanicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
