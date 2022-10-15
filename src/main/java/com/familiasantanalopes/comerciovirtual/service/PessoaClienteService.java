package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.dtos.PessoaCliesteRequesteDTO;
import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.repository.PessoaClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class PessoaClienteService {

    private final PessoaClienteRepository pessoaClienteRepository;
    private final PermissaoPessoaService permissaoPessoaService;
    private final EmailService emailService;
    public PessoaClienteService(PessoaClienteRepository pessoaClienteRepository, PermissaoPessoaService permissaoPessoaService,
                                EmailService emailService) {
        this.pessoaClienteRepository = pessoaClienteRepository;
        this.permissaoPessoaService = permissaoPessoaService;
        this.emailService = emailService;
    }


    public Pessoa savePessoa(PessoaCliesteRequesteDTO pessoaCliesteRequesteDTO){
        var pessoa=new Pessoa();
        BeanUtils.copyProperties(pessoaCliesteRequesteDTO,pessoa);
        pessoa.setDataCriacao(Instant.now());
        var objetoNovo=pessoaClienteRepository.save(pessoa);
        emailService.enviarEmailTexto(objetoNovo.getEmail(),"Cadastro na Loja Mais Varejo",
                "O seu restro na loja foi realizado com sucesso. Voce recebera a sua senha de acesso por email cadastrado");
       return pessoaClienteRepository.saveAndFlush(objetoNovo);

    }
}
