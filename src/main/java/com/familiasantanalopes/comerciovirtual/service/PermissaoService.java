package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Perissao;
import com.familiasantanalopes.comerciovirtual.repository.PermissaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;
    public PermissaoService(PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }
    @Transactional
    public Perissao savePermissao(Perissao permissao){
        permissao.setDataCreiacao(Instant.now());
        return permissaoRepository.saveAndFlush(permissao);

    }
    public Perissao findById(Long id){
        Optional<Perissao> perissao=permissaoRepository.findById(id);
        return perissao.get();
    }
    public List<Perissao> finAll(){
        List<Perissao>perissaos=permissaoRepository.findAll();
        return perissaos;
    }
    @Transactional
    public Perissao upDate(Long id,Perissao perissao){
        perissao.setDataAtualizacao(Instant.now());
        perissao.setId(id);
        return permissaoRepository.saveAndFlush(perissao);
    }
    @Transactional
    public void daletPermissao(Long id) {
        permissaoRepository.existsById(id);
    }

}
