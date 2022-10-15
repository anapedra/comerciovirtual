package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.CarrinhoCompra;
import com.familiasantanalopes.comerciovirtual.service.CarrinhoCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Carrinhos")
public class CarrinhoComproController {

    private final CarrinhoCompraService carrinhoCompraService;
    public CarrinhoComproController(CarrinhoCompraService carrinhoCompraService) {
        this.carrinhoCompraService = carrinhoCompraService;
    }

    @PostMapping
    public ResponseEntity<CarrinhoCompra> saveCarrinhoCompra(@RequestBody CarrinhoCompra carrinhoCompra){
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompraService.saveCarrinhoCompra(carrinhoCompra));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoCompra> findById(@PathVariable Long id){
        CarrinhoCompra carrinhoCompra=carrinhoCompraService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoCompra);
    }
    @GetMapping
    public ResponseEntity<List<CarrinhoCompra>> findAll(){
        List<CarrinhoCompra> carrinhoCompras=carrinhoCompraService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoCompras);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody CarrinhoCompra carrinhoCompra){
        carrinhoCompra=carrinhoCompraService.upDate(id, carrinhoCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompraService.saveCarrinhoCompra(carrinhoCompra));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletCarrinhoCompra(@PathVariable Long id){
        carrinhoCompraService.daletCidade(id);
        return ResponseEntity.status(HttpStatus.OK).body("Marca delatada com sucesso");
    }











}
