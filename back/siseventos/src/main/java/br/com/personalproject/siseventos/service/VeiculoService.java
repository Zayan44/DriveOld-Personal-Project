package br.com.personalproject.siseventos.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.entity.Cliente;
import br.com.personalproject.siseventos.entity.Veiculo;
import br.com.personalproject.siseventos.repository.ClienteRepository;
import br.com.personalproject.siseventos.repository.VeiculoRepository;

@Service
public class VeiculoService {
    
    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    //metodo para listar veiculos
    public ResponseEntity<Iterable<Veiculo>> listarVeiculo() {
        return ResponseEntity.ok(veiculoRepository.findAll()); 
    }

    //metodo para cadastrar veiculo
    public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long idCliente) {

        Optional<Cliente> clienteEncontrado = clienteRepository.findById(idCliente);

        veiculo.setCliente(clienteEncontrado.get());

        Veiculo veiculoComCliente = veiculoRepository.save(veiculo);

         URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{idVeiculo}")
        .buildAndExpand(veiculoComCliente.getIdVeiculo())
        .toUri();

        return ResponseEntity.created(location).body(veiculoComCliente);
    }

    //metodo para atualizar veiculos
    public ResponseEntity<?> atualizarVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long idVeiculo) {

        Optional<Veiculo> veiculoSalvo = veiculoRepository.findById(idVeiculo);
    
        Veiculo veiculoAtualizar = veiculoSalvo.get();

        veiculoAtualizar.setAno(veiculo.getAno());
        veiculoAtualizar.setCliente(veiculo.getCliente());
        veiculoAtualizar.setMarca(veiculo.getMarca());
        veiculoAtualizar.setModelo(veiculo.getModelo());
        veiculoAtualizar.setPlaca(veiculo.getPlaca());
        veiculoAtualizar.setTipo(veiculo.getTipo());

        veiculoRepository.save(veiculoAtualizar);

        return ResponseEntity.ok(veiculoAtualizar);
    }
    
    //metodo para deletar veiculos
    @DeleteMapping
    public ResponseEntity<?> deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
