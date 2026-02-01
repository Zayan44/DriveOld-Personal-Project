package br.com.personalproject.siseventos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.personalproject.siseventos.entity.Servico;
import br.com.personalproject.siseventos.repository.ServicoRepository;

@Service
public class ServicoService {
    
    @Autowired 
    ServicoRepository servicoRepository;

    public ResponseEntity<Iterable<Servico>> listarServico() {
        Iterable<Servico> servicos = servicoRepository.findAll();
        return ResponseEntity.ok(servicos);
}

    //Metodo para cadastrar mecanicos
    public ResponseEntity<?> cadastrarServico(Servico servico) {
        
        Servico servicoSalvo = servicoRepository.save(servico);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(servicoSalvo.getIdServico())
        .toUri();

        return ResponseEntity.created(location).body(servicoSalvo);
    }

    //Metodo para atualizar mecanicos
    public ResponseEntity<?> atualizarServico(Servico servico, Long id) {

        servico.setIdServico(id);

        Servico servicoAtualizar = servicoRepository.save(servico);
        
        return ResponseEntity.ok(servicoAtualizar);
    }

    //Metodo para deletar mecanicos
    public ResponseEntity<?> deletarServico(Long id) {
        servicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Metodo para buscar servico por id
    public Servico buscarServicoporId(Long idServico) {
        return servicoRepository.findById(idServico).get();
    }

}