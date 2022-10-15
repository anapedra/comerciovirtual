package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.CarrinhoCompra;
import com.familiasantanalopes.comerciovirtual.repository.CarrinhoCompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoCompraService {

    private final CarrinhoCompraRepository carrinhoCompraRepository;
    public CarrinhoCompraService(CarrinhoCompraRepository carrinhoCompraRepository) {
        this.carrinhoCompraRepository = carrinhoCompraRepository;
    }
    @Transactional
    public CarrinhoCompra saveCarrinhoCompra(CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataCriacao(Instant.now());
        carrinhoCompra.setDataCompra(Instant.now());
        return carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
    }
    public CarrinhoCompra findById(Long id){
        Optional<CarrinhoCompra> carrinhoCompra=carrinhoCompraRepository.findById(id);
        return carrinhoCompra.get();
    }
    public List<CarrinhoCompra> finAll(){
        List<CarrinhoCompra>carrinhoCompras=carrinhoCompraRepository.findAll();
        return carrinhoCompras;
    }
    @Transactional
    public CarrinhoCompra upDate(Long id,CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataAtualizacao(Instant.now());
        carrinhoCompra.setId(id);
        return carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
    }
    @Transactional
    public void daletCidade(Long id) {
        carrinhoCompraRepository.deleteById(id);
    }



}


