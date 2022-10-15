package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Cidade;
import com.familiasantanalopes.comerciovirtual.model.Estado;
import com.familiasantanalopes.comerciovirtual.repository.CidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    public Cidade saveCidade(Cidade cidade){
        cidade.setDataCriacao(Instant.now());
        return cidadeRepository.saveAndFlush(cidade);
    }
    public Cidade findById(Long id){
        Optional<Cidade> cidade=cidadeRepository.findById(id);
        return cidade.get();
    }
    public List<Cidade> finAll(){
        List<Cidade>cidades=cidadeRepository.findAll();
        return cidades;
    }
    @Transactional
    public Cidade upDate(Long id,Cidade cidade){
        cidade.setDataAtualizacao(Instant.now());
        cidade.setId(id);
        return cidadeRepository.saveAndFlush(cidade);
    }
    @Transactional
    public void daletCidade(Long id) {
        cidadeRepository.deleteById(id);
    }



}
