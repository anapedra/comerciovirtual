package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Cidade;
import com.familiasantanalopes.comerciovirtual.service.CidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }
    @PostMapping
    public ResponseEntity<Cidade> saveCidade(@RequestBody Cidade cidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.saveCidade(cidade));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id){
        Cidade cidade=cidadeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cidade);
    }
    @GetMapping
    public ResponseEntity<List<Cidade>> findAll(){
        List<Cidade> cidades=cidadeService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(cidades);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody Cidade cidade){
        cidade=cidadeService.upDate(id, cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.saveCidade(cidade));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletEstado(@PathVariable Long id){
        cidadeService.daletCidade(id);
        return ResponseEntity.status(HttpStatus.OK).body("Estado delatado com sucesso");

    }
}


