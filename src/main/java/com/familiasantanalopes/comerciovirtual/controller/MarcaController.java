package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Marca;
import com.familiasantanalopes.comerciovirtual.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping
    public ResponseEntity<Marca> savePessoa(@RequestBody Marca marca){
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.saveMarca(marca));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable Long id){
        Marca marca=marcaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(marca);
    }
    @GetMapping
    public ResponseEntity<List<Marca>> findAll(){
        List<Marca> marcas=marcaService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(marcas);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody Marca marca){
        marca.setDataAtualizacao(Instant.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.saveMarca(marca));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletEstado(@PathVariable Long id){
        marcaService.daletMarca(id);
        return ResponseEntity.status(HttpStatus.OK).body("Marca delatada com sucesso");

    }
}

