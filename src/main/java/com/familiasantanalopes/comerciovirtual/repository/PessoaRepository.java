package com.familiasantanalopes.comerciovirtual.repository;

import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    Pessoa findByEmail(String email);
    Pessoa findByEmailAndAndCodigoRecuperacaoSenha(String email,String codigoRecuperacaoSenha);

}
