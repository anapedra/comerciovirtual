package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.CarrinhoCompraProduto;
import com.familiasantanalopes.comerciovirtual.model.Cidade;
import com.familiasantanalopes.comerciovirtual.repository.CarrinhoCompraProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoCompraProdutoService {

    private final CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository;
    public CarrinhoCompraProdutoService(CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository) {
        this.carrinhoCompraProdutoRepository = carrinhoCompraProdutoRepository;
    }


    @Transactional
    public CarrinhoCompraProduto saveCarrinhoCompraProduto(CarrinhoCompraProduto carrinhoCompraProduto){
        carrinhoCompraProduto.setDataCriacao(Instant.now());
        return carrinhoCompraProdutoRepository.saveAndFlush(carrinhoCompraProduto);
    }
    public CarrinhoCompraProduto findById(Long id){
        Optional<CarrinhoCompraProduto> carrinhoCompraProduto=carrinhoCompraProdutoRepository.findById(id);
        return carrinhoCompraProduto.get();
    }
    public List<CarrinhoCompraProduto> finAll(){
        List<CarrinhoCompraProduto>carrinhoCompraProdutos=carrinhoCompraProdutoRepository.findAll();
        return carrinhoCompraProdutos;
    }
    @Transactional
    public CarrinhoCompraProduto upDate(Long id,CarrinhoCompraProduto carrinhoCompraProduto){
        carrinhoCompraProduto.setDataAtualizacao(Instant.now());
        carrinhoCompraProduto.setId(id);
        return carrinhoCompraProdutoRepository.saveAndFlush(carrinhoCompraProduto);
    }
    @Transactional
    public void daletCarrinhoCompraProduto(Long id) {
        carrinhoCompraProdutoRepository.deleteById(id);
    }



}


