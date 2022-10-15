package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.dtos.PessoaCliesteRequesteDTO;
import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.service.PessoaClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clietes")
public class PessoaClienteController {

    private final PessoaClienteService pessoaClienteService;
    public PessoaClienteController(PessoaClienteService pessoaClienteService) {
        this.pessoaClienteService = pessoaClienteService;
    }

    @PostMapping
    public ResponseEntity<Object> savePessoaCliete(@RequestBody PessoaCliesteRequesteDTO pessoaCliesteRequesteDTO){
        var pessoa=new Pessoa();
        BeanUtils.copyProperties(pessoaCliesteRequesteDTO,pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
}
