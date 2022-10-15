package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.CategoriaDoProduto;
import com.familiasantanalopes.comerciovirtual.service.CategoriaProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaProdutoService categoriaProdutoService;
    public CategoriaController(CategoriaProdutoService categoriaProdutoService) {
        this.categoriaProdutoService = categoriaProdutoService;
    }
    @PostMapping
    public ResponseEntity<CategoriaDoProduto> savePessoa(@RequestBody CategoriaDoProduto categoriaDoProduto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProdutoService.saveCategoria(categoriaDoProduto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDoProduto> findById(@PathVariable Long id){
        CategoriaDoProduto categoriaDoProduto=categoriaProdutoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDoProduto);
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDoProduto>> findAll(){
        List<CategoriaDoProduto> categoriaDoProdutos=categoriaProdutoService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDoProdutos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody CategoriaDoProduto categoriaDoProduto){
        categoriaDoProduto=categoriaProdutoService.upDate(id, categoriaDoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProdutoService.saveCategoria(categoriaDoProduto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletCategoria(@PathVariable Long id){
        categoriaProdutoService.daletCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body("Marca delatada com sucesso");
    }










}
