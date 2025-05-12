package com.estoque.vacina.clinica.repository;

import com.estoque.vacina.clinica.model.entity.Estoquista;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EstoquistaRepository  extends JpaRepository<Estoquista, UUID> {
}
