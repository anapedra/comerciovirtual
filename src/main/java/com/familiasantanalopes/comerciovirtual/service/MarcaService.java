package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Marca;
import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }
    @Transactional
    public Marca saveMarca(Marca marca){
        marca.setDataCreicao(Instant.now());
        return marcaRepository.saveAndFlush(marca);
    }
    public Marca findById(Long id){
        Optional<Marca> marca=marcaRepository.findById(id);
        return marca.get();
    }
    public List<Marca> finAll(){
        List<Marca>marcas=marcaRepository.findAll();
        return marcas;
    }
    @Transactional
    public Marca upDate(Long id,Marca marca){
        marca.setDataAtualizacao(Instant.now());
        marca.setId(id);
        return marcaRepository.saveAndFlush(marca);
    }
    @Transactional
    public void daletMarca(Long id) {
        marcaRepository.deleteById(id);
    }






}





