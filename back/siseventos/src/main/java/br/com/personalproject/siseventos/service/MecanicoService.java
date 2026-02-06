package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<MecanicoResponseDTO> listarMecanico() {

        List<Mecanico> mecanicos = mecanicoRepository.findAll();

        List<MecanicoResponseDTO> response = mecanicos
                .stream()
                .map(MecanicoMapper::toDto)
                .toList();

        return response;
    }

    // Método para cadastrar mecânicos
    @Transactional
    public MecanicoResponseDTO cadastrarMecanico(MecanicoRequestDTO dto) {
        Mecanico mecanico = MecanicoMapper.toEntity(dto);
        Mecanico mecanicoSalvo = mecanicoRepository.save(mecanico);
        MecanicoResponseDTO response = MecanicoMapper.toDto(mecanicoSalvo);
        return response;
    }

    //Metodo para atualizar mecanicos
    @Transactional
    public MecanicoResponseDTO atualizarMecanico(MecanicoRequestDTO dto, Long id) {
        Mecanico mecanico = MecanicoMapper.toEntity(dto);
        mecanico.setId(id);
        Mecanico mecanicoAtualizado = mecanicoRepository.save(mecanico);
        MecanicoResponseDTO response = MecanicoMapper.toDto(mecanicoAtualizado);
        return response;
    }

    // Método para deletar mecânicos
    @Transactional
    public void deletarMecanico(Long id) {
        mecanicoRepository.deleteById(id);
    }
}
