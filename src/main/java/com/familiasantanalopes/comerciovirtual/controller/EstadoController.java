package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Estado;
import com.familiasantanalopes.comerciovirtual.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @PostMapping
    public ResponseEntity<Estado> saveEstado(@RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.saveEstado(estado));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id){
        Estado estado=estadoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(estado);
    }
    @GetMapping
    public ResponseEntity<List<Estado>> findAll(){
        List<Estado> estados=estadoService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(estados);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody Estado estado){
        estado=estadoService.upDate(id, estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.saveEstado(estado));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletEstado(@PathVariable Long id){
        estadoService.daletEstado(id);
        return ResponseEntity.status(HttpStatus.OK).body("Estado delatado com sucesso");

    }
}
