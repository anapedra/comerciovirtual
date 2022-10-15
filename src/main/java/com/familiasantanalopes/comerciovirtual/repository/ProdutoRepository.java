package com.familiasantanalopes.comerciovirtual.repository;

import com.familiasantanalopes.comerciovirtual.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
