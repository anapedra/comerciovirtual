package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Perissao;
import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
@RestController
@RequestMapping("/permissaes")
public class PerissaoController {

    private final PermissaoService permissaoService;
    public PerissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @PostMapping
    public ResponseEntity<Perissao> savePermissa(@RequestBody Perissao perissao){
        return ResponseEntity.status(HttpStatus.CREATED).body(permissaoService.savePermissao(perissao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Perissao> findById(@PathVariable Long id){
        Perissao perissao=permissaoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(perissao);
    }
    @GetMapping
    public ResponseEntity<List<Perissao>> findAll(){
        List<Perissao> perissaos=permissaoService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(perissaos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody Perissao perissao){
        perissao.setDataAtualizacao(Instant.now());
        perissao=permissaoService.upDate(id, perissao);
        return ResponseEntity.status(HttpStatus.CREATED).body(permissaoService.savePermissao(perissao));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletEstado(@PathVariable Long id){
        permissaoService.daletPermissao(id);
        return ResponseEntity.status(HttpStatus.OK).body("Permissao delatado com sucesso");

    }

}
