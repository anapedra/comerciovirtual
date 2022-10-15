package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.savePessoa(pessoa));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa pessoa=pessoaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> pessoas=pessoaService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody Pessoa pessoa){
        pessoa=pessoaService.upDate(id, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.savePessoa(pessoa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletEstado(@PathVariable Long id){
        pessoaService.daletPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa delatado com sucesso");

    }
}


