package  br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.entity.Mecanico;
import br.com.personalproject.siseventos.repository.MecanicoRepository;

@Service
public class MecanicoService {
    
    @Autowired
    MecanicoRepository mecanicoRepository;

    //metodo para listar mecanicos
    public ResponseEntity<Iterable<Mecanico>> listarMecanico() {
        Iterable<Mecanico> mecanicos = mecanicoRepository.findAll();
        return ResponseEntity.ok(mecanicos);
}

    //Metodo para cadastrar mecanicos
    public ResponseEntity<?> cadastrarMecanico(Mecanico mecanico) {
        
        Mecanico mecanicoSalvo = mecanicoRepository.save(mecanico);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(mecanicoSalvo.getIdPessoa())
        .toUri();

        return ResponseEntity.created(location).body(mecanicoSalvo);
    }

    //Metodo para atualizar mecanicos
    public ResponseEntity<?> atualizarMecanico(Mecanico mecanico, Long id) {
        

        mecanico.setIdPessoa(id);

        Mecanico mecanicoAtualizar = mecanicoRepository.save(mecanico);
        
        return ResponseEntity.ok(mecanicoAtualizar);
    }

    //Metodo para deletar mecanicos
    public ResponseEntity<?> deletarMecanico(Long id) {
        mecanicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}