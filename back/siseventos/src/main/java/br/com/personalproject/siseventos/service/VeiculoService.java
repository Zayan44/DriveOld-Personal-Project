package br.com.personalproject.siseventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.personalproject.siseventos.dto.VeiculoRequestDTO;
import br.com.personalproject.siseventos.dto.VeiculoResponseDTO;
import br.com.personalproject.siseventos.entity.Cliente;
import br.com.personalproject.siseventos.entity.Veiculo;
import br.com.personalproject.siseventos.mapper.VeiculoMapper;
import br.com.personalproject.siseventos.repository.ClienteRepository;
import br.com.personalproject.siseventos.repository.VeiculoRepository;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<VeiculoResponseDTO> listarVeiculo() {

        List<VeiculoResponseDTO> veiculos = veiculoRepository.findAll()
                .stream()
                .map(VeiculoMapper::toDto)
                .toList();
        
        List<VeiculoResponseDTO> response = veiculos;

        return response;
    }

    public VeiculoResponseDTO cadastrarVeiculo(VeiculoRequestDTO dto, Long idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Veiculo veiculo = VeiculoMapper.toEntity(dto);
        veiculo.setCliente(cliente);
        veiculo = veiculoRepository.save(veiculo);
        VeiculoResponseDTO response = VeiculoMapper.toDto(veiculo);
        return response;
    }

    public VeiculoResponseDTO atualizarVeiculo(VeiculoRequestDTO dto, Long idVeiculo) {

        Veiculo veiculo = veiculoRepository.findById(idVeiculo).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        veiculo = VeiculoMapper.toUpdateEntity(dto, veiculo);

        veiculo = veiculoRepository.save(veiculo);

        VeiculoResponseDTO response = VeiculoMapper.toDto(veiculo);

        return response;
    }

    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }

    //Regras

    @Transactional
    public Veiculo buscarVeiculoPorId(Long idVeiculo) {
        return veiculoRepository.findById(idVeiculo).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));    
    }
}
