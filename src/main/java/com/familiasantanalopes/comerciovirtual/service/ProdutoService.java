package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Produto;
import com.familiasantanalopes.comerciovirtual.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Transactional
    public Produto saveProduto(Produto produto){
        produto.setDataCriacao(Instant.now());
        return produtoRepository.saveAndFlush(produto);
    }
    public Produto findById(Long id){
        Optional<Produto> produto=produtoRepository.findById(id);
        return produto.get();
    }
    public List<Produto> finAll(){
        List<Produto>produtos=produtoRepository.findAll();
        return produtos;
    }
    @Transactional
    public Produto upDate(Long id,Produto produto){
        produto.setDataAtualozacao(Instant.now());
        produto.setId(id);
        return produtoRepository.saveAndFlush(produto);
    }
    @Transactional
    public void daletCategoria(Long id) {
        produtoRepository.deleteById(id);
    }






}


