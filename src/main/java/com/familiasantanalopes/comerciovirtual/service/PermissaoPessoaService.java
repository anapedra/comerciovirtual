package com.familiasantanalopes.comerciovirtual.service;

import com.familiasantanalopes.comerciovirtual.model.Perissao;
import com.familiasantanalopes.comerciovirtual.model.PermissaPessoa;
import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import com.familiasantanalopes.comerciovirtual.repository.PermissaoPessoaRepository;
import com.familiasantanalopes.comerciovirtual.repository.PermissaoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PermissaoPessoaService {

    private final PermissaoPessoaRepository permissaoPessoaRepository;
    private final PermissaoRepository permissaoRepository;
    public PermissaoPessoaService(PermissaoPessoaRepository permissaoPessoaRepository, PermissaoRepository permissaoRepository) {
        this.permissaoPessoaRepository = permissaoPessoaRepository;
        this.permissaoRepository = permissaoRepository;
    }
    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List<Perissao> perissaoList = permissaoRepository.findByName("cliente");
        if (perissaoList.size() >0){
            PermissaPessoa permissaPessoa= new PermissaPessoa();
            permissaPessoa.setPessoa(pessoa);
            permissaPessoa.setPerissao(perissaoList.get(0));
            permissaPessoa.setDataCreiacao(Instant.now());
            permissaoPessoaRepository.save(permissaPessoa);
        }
    }
}
