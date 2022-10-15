package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.CarrinhoCompraProduto;
import com.familiasantanalopes.comerciovirtual.service.CarrinhoCompraProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhoscompraprodutos")
public class CarrinhoCompraProdutoController {
    private final CarrinhoCompraProdutoService carrinhoCompraProdutoService;
    public CarrinhoCompraProdutoController(CarrinhoCompraProdutoService carrinhoCompraProdutoService) {
        this.carrinhoCompraProdutoService = carrinhoCompraProdutoService;
    }

    @PostMapping
    public ResponseEntity<CarrinhoCompraProduto> saveCarrinhoCompraProduto(@RequestBody CarrinhoCompraProduto carrinhoCompraProduto){
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompraProdutoService.saveCarrinhoCompraProduto(carrinhoCompraProduto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoCompraProduto> findById(@PathVariable Long id){
        CarrinhoCompraProduto carrinhoCompraProduto=carrinhoCompraProdutoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoCompraProduto);
    }
    @GetMapping
    public ResponseEntity<List<CarrinhoCompraProduto>> findAll(){
        List<CarrinhoCompraProduto> carrinhoCompraProdutos=carrinhoCompraProdutoService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoCompraProdutos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody CarrinhoCompraProduto carrinhoCompraProduto){
        carrinhoCompraProduto=carrinhoCompraProdutoService.upDate(id, carrinhoCompraProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompraProdutoService.saveCarrinhoCompraProduto(carrinhoCompraProduto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletCarrinhoCompraProduto(@PathVariable Long id){
        carrinhoCompraProdutoService.daletCarrinhoCompraProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Marca delatada com sucesso");
    }


}
