package com.familiasantanalopes.comerciovirtual.repository;

import com.familiasantanalopes.comerciovirtual.model.CategoriaDoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaDoProduto,Long> {
}
