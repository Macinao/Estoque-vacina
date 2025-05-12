package com.estoque.vacina.clinica.repository;

import com.estoque.vacina.clinica.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface FornecedorRepository  extends JpaRepository<Fornecedor, UUID> {
}
