package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculo() {

            List<VeiculoResponseDTO> veiculos = veiculoRepository.findAll()
                    .stream()
                    .map(VeiculoMapper::toDto)
                    .toList();

            return ResponseEntity.ok(veiculos);
    }

    public ResponseEntity<VeiculoResponseDTO> cadastrarVeiculo(VeiculoRequestDTO dto, Long idCliente) {

        Optional<Cliente> clienteEncontrado = clienteRepository.findById(idCliente);

        if (clienteEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Veiculo veiculo = VeiculoMapper.toEntity(dto);

        veiculo.setCliente(clienteEncontrado.get());

        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculoSalvo.getIdVeiculo())
                .toUri();

        VeiculoResponseDTO dtoResponse = VeiculoMapper.toDto(veiculoSalvo);

        return ResponseEntity.created(location).body(dtoResponse);
}


    // Atualizar veículo
    public ResponseEntity<VeiculoResponseDTO> atualizarVeiculo(VeiculoRequestDTO dto, Long idVeiculo) {

        Optional<Veiculo> veiculoSalvo = veiculoRepository.findById(idVeiculo);

        if (veiculoSalvo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        VeiculoMapper.toUpdateEntity(dto, veiculoSalvo.get());

        Veiculo atualizado = veiculoRepository.save(veiculoSalvo.get());

        VeiculoResponseDTO dtoResponse = VeiculoMapper.toDto(atualizado);

        return ResponseEntity.ok(dtoResponse);
    }

    // Deletar veículo
    public ResponseEntity<Void> deletarVeiculo(Long id) {

        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por ID
    @Transactional
    public Veiculo buscarVeiculoPorId(Long idVeiculo) {

        return veiculoRepository.findById(idVeiculo).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));    
    }
}
