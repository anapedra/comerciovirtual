package com.familiasantanalopes.comerciovirtual.repository;

import com.familiasantanalopes.comerciovirtual.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaClienteRepository extends JpaRepository<Pessoa,Long> {
}
