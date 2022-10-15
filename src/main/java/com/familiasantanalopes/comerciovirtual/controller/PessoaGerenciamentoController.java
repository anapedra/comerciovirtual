package com.familiasantanalopes.comerciovirtual.controller;

import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.service.PessoaGerenciamentoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa-gerenciamento")
public class PessoaGerenciamentoController {

    private final PessoaGerenciamentoService pessoaGerenciamentoServiceService;
    public PessoaGerenciamentoController(PessoaGerenciamentoService pessoaGerenciamentoServiceService) {
        this.pessoaGerenciamentoServiceService = pessoaGerenciamentoServiceService;
    }

    @PostMapping
    public String recuperarCodigo(@RequestBody Pessoa pessoa){
        return pessoaGerenciamentoServiceService.solicitarCodigo(pessoa.getEmail());
    }
    /*
    @PostMapping(value = "/senha-alterar")
    public String recuperarSenha(@RequestBody Pessoa pessoa){
        return pessoaGerenciamentoServiceService.AlterarSenha(pessoa);
    }

     */
}
