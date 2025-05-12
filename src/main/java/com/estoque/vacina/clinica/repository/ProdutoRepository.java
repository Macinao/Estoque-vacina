package com.estoque.vacina.clinica.repository;

import com.estoque.vacina.clinica.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProdutoRepository  extends JpaRepository<Produto, UUID> {
}
