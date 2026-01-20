package br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.entity.Peca;
import br.com.personalproject.siseventos.repository.PecaRepository;

@Service
public class PecaService {
    
    @Autowired 
    PecaRepository pecaRepository;

    public ResponseEntity<Iterable<Peca>> listarPeca() {
        Iterable<Peca> pecas = pecaRepository.findAll();
        return ResponseEntity.ok(pecas);
}

    //Metodo para cadastrar mecanicos
    public ResponseEntity<?> cadastrarPeca(Peca peca) {
        
        Peca pecaSalvo = pecaRepository.save(peca);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(pecaSalvo.getIdPeca())
        .toUri();

        return ResponseEntity.created(location).body(pecaSalvo);
    }

    //Metodo para atualizar mecanicos
    public ResponseEntity<?> atualizarPeca(Peca peca, Long id) {

        peca.setIdPeca(id);

        Peca pecaAtualizar = pecaRepository.save(peca);
        
        return ResponseEntity.ok(pecaAtualizar);
    }

    //Metodo para deletar mecanicos
    public ResponseEntity<?> deletarPeca(Long id) {
        pecaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}