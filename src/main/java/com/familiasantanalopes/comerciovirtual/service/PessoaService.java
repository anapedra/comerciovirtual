package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Cidade;
import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    @Transactional
    public Pessoa savePessoa(Pessoa pessoa){
        pessoa.setDataCriacao(Instant.now());
        return pessoaRepository.saveAndFlush(pessoa);
    }
    public Pessoa findById(Long id){
        Optional<Pessoa> pessoa=pessoaRepository.findById(id);
        return pessoa.get();
    }
    public List<Pessoa> finAll(){
        List<Pessoa>pessoas=pessoaRepository.findAll();
        return pessoas;
    }
    @Transactional
    public Pessoa upDate(Long id,Pessoa pessoa){
        pessoa.setDataAtualozacao(Instant.now());
        pessoa.setId(id);
        return pessoaRepository.saveAndFlush(pessoa);
    }
    @Transactional
    public void daletPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }



}


