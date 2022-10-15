package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Estado;
import com.familiasantanalopes.comerciovirtual.repository.EstadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }
    @Transactional
    public Estado saveEstado(Estado estado){
        estado.setDataCriação(Instant.now());
        return estadoRepository.saveAndFlush(estado);
    }
    public Estado findById(Long id){
        Optional<Estado>estado=estadoRepository.findById(id);
        return estado.get();
    }
    public List<Estado> finAll(){
        List<Estado>estados=estadoRepository.findAll();
        return estados;
    }
    @Transactional
    public Estado upDate(Long id,Estado estado){
        estado.setDataAtualizacao(Instant.now());
        estado.setId(id);
        return estadoRepository.saveAndFlush(estado);
    }
    @Transactional
    public void daletEstado(Long id){
        estadoRepository.deleteById(id);
    }
}
