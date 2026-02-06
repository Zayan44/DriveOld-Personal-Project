package br.com.personalproject.siseventos.service;

import java.util.List;
import java.util.Optional;

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

// Listar veículos
    public List<VeiculoResponseDTO> listarVeiculo() {

        List<VeiculoResponseDTO> veiculos = veiculoRepository.findAll()
                .stream()
                .map(VeiculoMapper::toDto)
                .toList();
        
        List<VeiculoResponseDTO> response = veiculos;

        return response;
    }

// Cadastrar veiculos
    public VeiculoResponseDTO cadastrarVeiculo(VeiculoRequestDTO dto, Long idCliente) {

        Optional<Cliente> clienteEncontrado = clienteRepository.findById(idCliente);

        if (clienteEncontrado.isEmpty()) {
            //exceção
        }

        Veiculo veiculo = VeiculoMapper.toEntity(dto);
        veiculo.setCliente(clienteEncontrado.get());
        veiculo = veiculoRepository.save(veiculo);
        VeiculoResponseDTO response = VeiculoMapper.toDto(veiculo);
        return response;
    }

    // Atualizar veículo
    public VeiculoResponseDTO atualizarVeiculo(VeiculoRequestDTO dto, Long idVeiculo) {

        Optional<Veiculo> veiculoEncontrado = veiculoRepository.findById(idVeiculo);

        if (veiculoEncontrado.isEmpty()) {
            //exceção
        }

        Veiculo veiculo = veiculoEncontrado.get();

        veiculo = VeiculoMapper.toUpdateEntity(dto, veiculo);

        veiculo = veiculoRepository.save(veiculo);

        VeiculoResponseDTO response = VeiculoMapper.toDto(veiculo);

        return response;
    }

    // Deletar veículo
    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }

    // Buscar por ID
    @Transactional
    public Veiculo buscarVeiculoPorId(Long idVeiculo) {

        return veiculoRepository.findById(idVeiculo).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));    
    }
}
