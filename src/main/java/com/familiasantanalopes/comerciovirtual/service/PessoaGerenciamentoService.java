package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PessoaGerenciamentoService {
//PARA CRIPTOGRAFAR A SENHA DEPOIS COM O SPRING SECURITY!
    private PessoaRepository pessoaRepository;
    private EmailService emailService;
    public PessoaGerenciamentoService(PessoaRepository pessoaRepository, EmailService emailService) {
        this.pessoaRepository = pessoaRepository;
        this.emailService = emailService;
    }
    public String solicitarCodigo(String email){
        var pessoa= pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataValidadeCodigo(new Date());
        pessoaRepository.save(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(),"Codigo de Recuperação",
                "Use esse codigo para recuperacao da sua senha"+pessoa.getCodigoRecuperacaoSenha());
        return "";
    }

    public String AlterarSenha(Pessoa pessoa){
        Pessoa pessoaBamco=pessoaRepository.findByEmailAndAndCodigoRecuperacaoSenha(pessoa.getEmail(),pessoa.getCodigoRecuperacaoSenha());
        if (pessoaBamco != null){
             Date diferença=new Date(new Date().getTime() - pessoaBamco.getDataValidadeCodigo().getTime());
             if (diferença.getTime()/1000 < 900){
                 pessoaBamco.setSenha(pessoa.getSenha());
                 pessoaBamco.setCodigoRecuperacaoSenha(null);
                 pessoaRepository.saveAndFlush(pessoaBamco);
                 return "SENA ALTERADA COM SUCESSO!";
             }else {
            return "Tempo expirado, solicite um novo codigo!";
             }
        }else {
            return "Email ou codigo nao encontrado!";
        }
    }
    private String getCodigoRecuperacaoSenha(Long id){
        DateFormat format=new SimpleDateFormat("dd-MM-yyyy-ss-mm");
        return format.format(new Date())+id;
    }

}
