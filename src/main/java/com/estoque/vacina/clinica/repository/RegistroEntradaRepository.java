package com.estoque.vacina.clinica.repository;

import com.estoque.vacina.clinica.model.entity.RegistroEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RegistroEntradaRepository extends JpaRepository<RegistroEntrada, UUID> {
}
