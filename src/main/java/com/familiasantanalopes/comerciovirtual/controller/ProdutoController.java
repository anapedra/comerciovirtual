package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Produto;
import com.familiasantanalopes.comerciovirtual.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @PostMapping
    public ResponseEntity<Produto> savePessoa(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto=produtoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produtos=produtoService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody Produto produto){
        produto=produtoService.upDate(id, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletEstado(@PathVariable Long id){
        produtoService.daletCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body("Marca delatada com sucesso");
    }











}
