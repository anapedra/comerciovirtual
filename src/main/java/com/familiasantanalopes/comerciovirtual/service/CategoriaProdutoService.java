package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.CategoriaDoProduto;
import com.familiasantanalopes.comerciovirtual.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaProdutoService {

    private final CategoriaRepository categoriaRepository;
    public CategoriaProdutoService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    @Transactional
    public CategoriaDoProduto saveCategoria(CategoriaDoProduto categoriaDoProduto){
        categoriaDoProduto.setDataCriacao(Instant.now());
        return categoriaRepository.saveAndFlush(categoriaDoProduto);
    }
    public CategoriaDoProduto findById(Long id){
        Optional<CategoriaDoProduto> categoriaDoProduto=categoriaRepository.findById(id);
        return categoriaDoProduto.get();
    }
    public List<CategoriaDoProduto> finAll(){
        List<CategoriaDoProduto>categoriaDoProdutos=categoriaRepository.findAll();
        return categoriaDoProdutos;
    }
    @Transactional
    public CategoriaDoProduto upDate(Long id,CategoriaDoProduto categoriaDoProduto){
        categoriaDoProduto.setDataAtualizacao(Instant.now());
        categoriaDoProduto.setId(id);
        return categoriaRepository.saveAndFlush(categoriaDoProduto);
    }
    @Transactional
    public void daletCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }






}
