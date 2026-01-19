package  br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.entity.Cliente;
import br.com.personalproject.siseventos.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity<Iterable<Cliente>> listarCliente() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
}

    //Metodo para cadastrar Clientes
    public ResponseEntity<?> cadastrarCliente(Cliente cliente) {
        
        Cliente clienteSalvo = clienteRepository.save(cliente);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(clienteSalvo.getIdPessoa())
        .toUri();

        return ResponseEntity.created(location).body(clienteSalvo);
    }

    //Metodo para atualizar Clientes
    public ResponseEntity<?> atualizarCliente(Cliente cliente, Long id) {
        

        cliente.setIdPessoa(id);

        Cliente clienteAtualizar = clienteRepository.save(cliente);
        
        return ResponseEntity.ok(clienteAtualizar);
    }

    //Metodo para deletar Clientes
    public ResponseEntity<?> deletarCliente(Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}