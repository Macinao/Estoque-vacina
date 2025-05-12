package com.estoque.vacina.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RegistroEntradaRepository extends JpaRepository<RegistroEntradaRepository, UUID> {
}
