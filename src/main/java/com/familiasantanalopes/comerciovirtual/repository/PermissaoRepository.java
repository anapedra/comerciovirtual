package com.familiasantanalopes.comerciovirtual.repository;

import com.familiasantanalopes.comerciovirtual.model.Perissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Perissao,Long> {

    List<Perissao>findByName(String name);

}
